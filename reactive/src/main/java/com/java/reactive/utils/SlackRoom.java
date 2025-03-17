package com.java.reactive.utils;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class SlackRoom {

    private String name;
    private Sinks.Many<SlackMessage> sinks;
    private Flux<SlackMessage> flux;

    public SlackRoom(String name) {
        this.name = name;
        this.sinks= Sinks.many().replay().all();// late people can view message
        this.flux = sinks.asFlux();
    }

    public void joinRoom(SlackMember member) {
        System.out.println("Joining room " + member.getName()+": "+this.name);
        subscribes(member);
        member.setMessageConsumer(msg->postMessage(msg,member));

    }


    private void subscribes(SlackMember member) {
        this.flux
                .filter(sm->!sm.getSender().equals(member.getName()))
                .doOnNext(sm->sm.setReceiver(member.getName()))
                .map(SlackMessage::toString)
                .subscribe(member::received);

                //.subscribe(slackMsg->member.received(slackMsg.getMessage()));
    }

    private void postMessage(String message,SlackMember member){
        SlackMessage slackMessage =new SlackMessage();
        slackMessage.setSender(member.getName());
        slackMessage.setMessage(message);
        this.sinks.tryEmitNext(slackMessage);
    }

}
