package com.java.reactive.exercise;

import com.java.reactive.utils.SlackMember;
import com.java.reactive.utils.SlackRoom;

public class Sink_exercise {
    public static void main(String[] args) {
        SlackRoom room=new SlackRoom("Java Reactive Class");
        SlackMember mrLang=new SlackMember("Menglang");
        SlackMember mrLong=new SlackMember("Mr.Long ");

        room.joinRoom(mrLang);
        room.joinRoom(mrLong);

        mrLang.says("Hello Mr.Long.....!");
        mrLong.says("Hello Mr.Lang Are You Free Today!");

        SlackMember thida=new SlackMember("Thida");
        room.joinRoom(thida);
        thida.says("Hello Mr.Long & Mr.Lang ");

    }
}
