package com.sjp.sjpapi;

public class CurlWrapper {

    public String wrappCurl(String curlOutput) {
        return getBettwenH1AndCommentSection(curlOutput);
    }

    public String getBettwenH1AndCommentSection(String curlOutput) {

        String outputBettwenH1AndComment = curlOutput;

        String h1SectionStart = "<h1";
        String CommentSectionStart = "KOMENTARZE:";
        outputBettwenH1AndComment = StringUtils.substringBettwen(outputBettwenH1AndComment,h1SectionStart,CommentSectionStart);

        return outputBettwenH1AndComment;
    }


}
