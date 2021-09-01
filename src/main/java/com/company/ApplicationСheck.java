package com.company;

public class ApplicationСheck {

    public boolean checkNewAppl(String[] futureAppl){
        return checkNewAction(futureAppl[1]) && checkNewAmount(futureAppl[3], futureAppl[4]);
    }

    public boolean checkExistAppl(Application applicationOld, String[] applicationNew){
     return checkExistAction(applicationNew[1])
             && checkExisAmount(applicationOld.getAmountRest(), applicationNew[3], applicationNew[4]);
    }

    private boolean checkExistAction (String action) {
        char[] actionCh = action.toCharArray();

        if(actionCh.length == 1 && actionCh[0] == '1') {
            return true;
        }
        return false;
    }

    private boolean checkExisAmount (int amountRestOld, String amountNew, String amountRestNew) {
        return amountRestOld == Integer.parseInt(amountNew) + Integer.parseInt(amountRestNew);
    }


    private boolean checkNewAction (String action) {
        char[] actionCh = action.toCharArray();

        if(actionCh.length == 1 && (actionCh[0] == '0' || actionCh[0] == '1')) {
            return true;
        }
        return false;
    }

    private boolean checkNewAmount (String amount, String amountRest) {
        return amount.equals(amountRest);
    }
}
