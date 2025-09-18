package com.di.spring_di_xml_constructor_ex;

public class TV {
	// TV는 Speaker에 의존
    private Speaker speaker;
    
    // 생성자를 통해 Speaker 객체를 외부에서 주입
    public TV(Speaker speaker) {
        this.speaker = speaker;
    }

    public void volumeUp() {
        speaker.volumeUp();
    }

    public void volumeDown() {
        speaker.volumeDown();
    }
}
