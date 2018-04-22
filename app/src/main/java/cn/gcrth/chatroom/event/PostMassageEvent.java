package cn.gcrth.chatroom.event;

import cn.gcrth.chatroom.entity.Massage;

public class PostMassageEvent {
    private Massage massagetopost;

    public PostMassageEvent(Massage massagetopost) {
        this.massagetopost = massagetopost;
    }

    public Massage getMassagetopost() {
        return massagetopost;
    }

    public void setMassagetopost(Massage massagetopost) {
        this.massagetopost = massagetopost;
    }

    public boolean posttoscreen() {

        return true;
    }

    public boolean posttodb() {

        return true;
    }

    public boolean posttosever() {

        return true;
    }
}
