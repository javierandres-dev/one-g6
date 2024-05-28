package ext.domain.screenmatch.service;

import com.theokanning.openai.service.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;

public class RequestChatGPT {
    public  static  String getTranslation(String text){
        final String API_KEY = "API-KEY";

        OpenAiService openAiService = new OpenAiService(API_KEY);

        CompletionRequest completionRequest = CompletionRequest.builder()
                .model("gpt-3.5-turbo-instruct")
                .prompt("Please, translate the following text into Spanish: " + text)
                .maxTokens(1000)
                .temperature(0.7)
                .build();
        System.out.println("before...");
        var response = openAiService.createCompletion(completionRequest);
        System.out.println("...after");
        System.out.println("response: " + response);
        return  response.getChoices().get(0).getText();
    }
}
