package org.example.reviewmakerchatgpt.util;

import org.example.reviewmakerchatgpt.dto.ReviewInformationDTO;

public class PromptGenerator {

    public static String generateKoreanReviewPrompt(ReviewInformationDTO reviewInformation) {
        StringBuilder question = new StringBuilder("지금 제품 리뷰를 작성하려고 해! ");
        question.append("이 제품의 카테고리는 ").append(reviewInformation.getCategory()).append("이고, ");

        if (!reviewInformation.getSubCategory().isEmpty()) {
            question.append("그 카테고리의 하위 카테고리는 ")
                    .append(reviewInformation.getSubCategory())
                    .append("이며, ");
        }

        question.append("이 제품의 품질은 ")
                .append(getGeneralizedPoint(reviewInformation.getQuality()))
                .append("이야. ")
                .append("가성비는 ")
                .append(getGeneralizedPoint(reviewInformation.getCostPerformance()))
                .append("정도인 것 같아. ")
                .append("리뷰 작성자의 성별은 ")
                .append(reviewInformation.getGender())
                .append("이고, ")
                .append(getGeneralizedText(reviewInformation.getAge()))
                .append("대입니다. ")
                .append("리뷰의 길이는 공백을 제외하고 ")
                .append(getGeneralizedText(reviewInformation.getLength()))
                .append("글자 이상이어야 해!, ")
                .append("이 제품의 세부 사항과 리뷰 제한 사항을 참고해서 매우 자연스럽고 집에 누워서 편하게 작성한 것 같은 리뷰를 작성해줘!!");

        return question.toString();
    }

    private static String getGeneralizedPoint(String point) {
        return switch (point) {
            case "1점" -> "매우 나쁨";
            case "2점" -> "나쁨";
            case "3점" -> "보통";
            case "4점" -> "좋음";
            default -> "매우 좋음";
        };
    }

    private static String getGeneralizedText(String text) {
        return text.substring(0, text.length() - 1);
    }
}
