package Transaction_Service.view.Transfer;

import Entities.User.User;
import Transaction_Service.Controllers.TransferController;

public interface TransferView {
    public void Transfer(TransferController transferController, User user);
}
