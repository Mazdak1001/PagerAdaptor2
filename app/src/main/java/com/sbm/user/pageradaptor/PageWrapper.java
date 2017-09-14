package com.sbm.user.pageradaptor;

import java.util.Random;

public class PageWrapper {
    String county;
    Random random=new Random();

    String capital;
    int imageId;
    int spinnerposition=random.nextInt(4);
/*public String countries(String countries) {
    return countries;
}
    public String capital(String capital){
        return capital;
    }
    public int flag(int flag){
        return flag;
    }*/
}