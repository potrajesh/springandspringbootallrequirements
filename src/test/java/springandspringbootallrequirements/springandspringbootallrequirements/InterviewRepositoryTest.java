package springandspringbootallrequirements.springandspringbootallrequirements;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.controller.SpringandspringbootallrequirementsApplication;
import com.cts.dao.CandidateRepo;
import com.cts.dao.InterviewRepo;
import com.cts.model.Candidate;
import com.cts.model.Interview;

@SpringBootTest(classes = SpringandspringbootallrequirementsApplication.class)
public class InterviewRepositoryTest {

    @Autowired
    private InterviewRepo interviewRepository;

    @Autowired
    private CandidateRepo candidateRepository;

    @Test
    void testSaveInterviewWithCandidates() {
        // Create interview
        Interview interview = new Interview();
        interview.setInterviewId(1243);
        interview.setCompanyName("Google");
        interview.setDate("2025-02-19");
        interview.setFailedquestions("What is Spring Boot?");
        interview.setAnswers("Spring Boot is a Java framework.");

        // Create candidates
        Candidate candidate1 = new Candidate();
        candidate1.setCandidateName("John Doe");
        candidate1.setInterview(interview);

        Candidate candidate2 = new Candidate();
        candidate2.setCandidateName("Jane Smith");
        candidate2.setInterview(interview);

        // Associate candidates with interview
        interview.setCandidate(Arrays.asList(candidate1,candidate2));

        // Save interview (cascade will save candidates)
        Interview savedInterview = interviewRepository.save(interview);

        // Verify interview was saved
        assertThat(savedInterview.getInterviewId()).isGreaterThan(0);
        assertThat(savedInterview.getCandidate()).hasSize(2);
    }

    @Test
    void testFindInterviewWithCandidates() {
        // Save interview with candidates first
        Interview interview = new Interview();
        interview.setInterviewId(123);
        interview.setCompanyName("Amazon");
        interview.setDate("2025-02-19");
        interview.setFailedquestions("Explain polymorphism.");
        interview.setAnswers("Polymorphism allows different classes to be used interchangeably.");

        Candidate candidate = new Candidate();
        candidate.setCandidateName("Alice Johnson");
        candidate.setInterview(interview);
        interview.setCandidate(Arrays.asList(candidate));

        Interview savedInterview = interviewRepository.save(interview);
        int interviewId = savedInterview.getInterviewId();

        // Retrieve interview
        Optional<Interview> retrievedInterview = interviewRepository.findById(interviewId);
        assertThat(retrievedInterview).isPresent();
        assertThat(retrievedInterview.get().getCandidate()).hasSize(1);
        assertThat(retrievedInterview.get().getCandidate().get(0).getCandidateName()).isEqualTo("Alice Johnson");
    }
}
