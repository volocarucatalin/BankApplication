package controller;

import service.TransferService;

public class TransferController {
    private TransferService transferService;


    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    public void transferBetween(int senderSortCode, int receiverSortCode, long sendBalance) {
        transferService.transferBetween(senderSortCode, receiverSortCode, sendBalance);
    }


}
