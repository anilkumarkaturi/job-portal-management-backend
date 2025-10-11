package com.job_portal.config;

import com.job_portal.model.*;
import com.job_portal.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;
import java.util.Arrays;

@Configuration
public class DataInitializer {
    private static final Logger logger = LoggerFactory.getLogger(DataInitializer.class);

    @Bean
    public CommandLineRunner initData(UserRepository userRepository,
                                      UserTypeRepository userTypeRepository,
                                      JobLocationRepository jobLocationRepository,
                                      JobPostActivityRepository jobPostActivityRepository,
                                      JobSeekerProfileRepository jobSeekerProfileRepository,
                                      JobSeekerApplyRepository jobSeekerApplyRepository,
                                      JobSeekerSaveRepository jobSeekerSaveRepository,
                                      RecruiterProfileRepository recruiterProfileRepository) {
        return args -> {
            // Comment this block to disable data initialization
            logger.info("Initializing dummy data...");

            // Cleanup duplicates in users_type table (one-time)
            for (String typeName : Arrays.asList("Admin", "Recruiter", "Seeker")) {
                var types = userTypeRepository.findAllByUserTypeName(typeName);
                if (types.size() > 1) {
                    // Keep the first, delete the rest
                    for (int i = 1; i < types.size(); i++) {
                        userTypeRepository.delete(types.get(i));
                    }
                }
                if (types.isEmpty()) {
                    UserType newType = new UserType();
                    newType.setUserTypeName(typeName);
                    userTypeRepository.save(newType);
                }
            }

            // Always fetch managed UserType entities for relationships
            UserType adminTypeManaged = userTypeRepository.findAllByUserTypeName("Admin").get(0);
            UserType recruiterTypeManaged = userTypeRepository.findAllByUserTypeName("Recruiter").get(0);
            UserType seekerTypeManaged = userTypeRepository.findAllByUserTypeName("Seeker").get(0);

            // Users
            // Use entity references to avoid detached/persist issues
            UserType adminRef = userTypeRepository.getReferenceById(adminTypeManaged.getUserTypeId());
            UserType recruiterRef = userTypeRepository.getReferenceById(recruiterTypeManaged.getUserTypeId());
            UserType seekerRef = userTypeRepository.getReferenceById(seekerTypeManaged.getUserTypeId());

            User user1 = new User();
            user1.setEmail("u-1@example.com");
            user1.setPassword("pass1");
            user1.setIsActive(true);
            user1.setRegistrationDate(new Date(System.currentTimeMillis()));
            user1.setUserTypeId(seekerTypeManaged);
            user1.setUserTypeId(seekerRef);
            User user2 = new User();
            user2.setEmail("u-2@example.com");
            user2.setPassword("pass2");
            user2.setIsActive(true);
            user2.setRegistrationDate(new Date(System.currentTimeMillis()));
            user2.setUserTypeId(recruiterTypeManaged);
            user2.setUserTypeId(recruiterRef);
            User user3 = new User();
            user3.setEmail("u-3@example.com");
            user3.setPassword("pass3");
            user3.setIsActive(true);
            user3.setRegistrationDate(new Date(System.currentTimeMillis()));
            user3.setUserTypeId(adminTypeManaged);
            user3.setUserTypeId(adminRef);
            userRepository.saveAll(Arrays.asList(user1, user2, user3));

            // JobLocation
            JobLocation location1 = new JobLocation();
            location1.setCity("City1");
            location1.setCountry("Country1");
            location1.setState("State1");
            jobLocationRepository.save(location1);

            // JobPostActivity
            JobPostActivity jobPost = new JobPostActivity();
            jobPost.setDescriptionOfJob("Sample job description");
            jobPost.setJobTitle("Developer");
            jobPost.setJobType("Full-Time");
            jobPost.setPostedDate(new Date(System.currentTimeMillis()));
            jobPost.setRemote("No");
            jobPost.setSalary("50000");
            jobPost.setJobCompanyId(1);
            jobPost.setJobLocationId(location1);
            jobPost.setPostById(user2); // recruiter
            jobPostActivityRepository.save(jobPost);

            // JobSeekerProfile
            JobSeekerProfile profile1 = new JobSeekerProfile();
            profile1.setFirstName("John");
            profile1.setLastName("Doe");
            profile1.setCity("City1");
            // Persist and flush so the instance becomes managed in the current persistence context
            JobLocation savedLocation = jobLocationRepository.saveAndFlush(location1);
            profile1.setState("State1");
            profile1.setProfilePhoto("profile1.jpg");
            profile1.setResume("resume1.pdf");
            profile1.setWorkAuthorization("Yes");
            jobSeekerProfileRepository.save(profile1);

            // JobSeekerApply
            JobSeekerApply apply1 = new JobSeekerApply();
            apply1.setApplyDate(new Date(System.currentTimeMillis()));
            apply1.setCoverLetter("I am interested in this job.");
            // assign the managed JobLocation instance
            jobPost.setJobLocationId(savedLocation);
            apply1.setJob(jobPost);
            jobPostActivityRepository.saveAndFlush(jobPost);

            // JobSeekerSave
            JobSeekerSave save1 = new JobSeekerSave();
            save1.setJobPostActivity(jobPost);
            save1.setUser(user1); // Fix: use User, not JobSeekerProfile
            jobSeekerSaveRepository.save(save1);

            // RecruiterProfile
            RecruiterProfile recruiterProfile = new RecruiterProfile();
            recruiterProfile.setFirstName("Recruiter");
            recruiterProfile.setLastName("One");
            recruiterProfile.setCountry("RecruiterCompany");
            recruiterProfile.setCity("City2");
            recruiterProfile.setCountry("Country2");
            recruiterProfile.setState("State2");
            recruiterProfile.setProfilePhoto("recruiter1.jpg");
            recruiterProfile.setState("Andhra pradesh");
            recruiterProfileRepository.save(recruiterProfile);

            logger.info("Dummy data initialization complete.");
        };
    }
}
