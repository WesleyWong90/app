package royalstacks.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PosValidator {

    @Id
    @GeneratedValue
    protected int id;
    @OneToOne
    private BusinessAccount bussinessAccount;
    private int validationCode;

    public PosValidator(BusinessAccount businessAccount, int validationCode) {
        this.bussinessAccount = bussinessAccount;
        this.validationCode = validationCode;
    }

    public PosValidator() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BusinessAccount getBussinessAccount() {
        return bussinessAccount;
    }

    public void setBussinessAccount(BusinessAccount bussinessAccount) {
        this.bussinessAccount = bussinessAccount;
    }

    public int getValidationCode() {
        return validationCode;
    }

    public void setValidationCode(int validationCode) {
        this.validationCode = validationCode;
    }

    @Override
    public String toString() {
        return "PosValidator{" +
                "id=" + id +
                ", bussinessAccount=" + bussinessAccount +
                ", validationCode=" + validationCode +
                '}';
    }
}
