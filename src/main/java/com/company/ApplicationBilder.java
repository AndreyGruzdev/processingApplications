package com.company;

public class ApplicationBilder {

    public Application createAppl(String[] futureAppl){
        char[] action = futureAppl[1].toCharArray();

        return new Application(futureAppl[0], action[0], Long.parseLong(futureAppl[2]),
                Integer.parseInt(futureAppl[3]), Integer.parseInt(futureAppl[4]));
    }

    public Application changeAppl(Application applicationOld, String[] applicationNew) {
        char[] action = applicationNew[1].toCharArray();

        applicationOld.setAction(action[0]);
        applicationOld.setPrice(Long.parseLong(applicationNew[2]));
        applicationOld.setAmount(Integer.parseInt(applicationNew[3]));
        applicationOld.setAmountRest(Integer.parseInt(applicationNew[4]));

        return applicationOld;
    }
}
