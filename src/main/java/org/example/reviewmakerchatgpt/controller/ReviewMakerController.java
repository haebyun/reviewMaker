package org.example.reviewmakerchatgpt.controller;

import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.example.reviewmakerchatgpt.dto.ReviewInformationDTO;
import org.example.reviewmakerchatgpt.service.ReviewMakerService;
import org.example.reviewmakerchatgpt.util.PromptGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ReviewMakerController {
    private final ReviewMakerService reviewMakerService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("reviewInformationDTO", new ReviewInformationDTO());
        return "index";
    }

    @PostMapping("/")
    public String generateReview(@ModelAttribute ReviewInformationDTO reviewInformationDTO, Model model) throws IOException {
        String request = PromptGenerator.generateKoreanReviewPrompt(reviewInformationDTO);
        String responseText = reviewMakerService.makeReview(request);
        responseText += "\n" + reviewInformationDTO.getAdditionalText();

        model.addAttribute("responseText", responseText);
        return "index";
    }
}
