package processorejb.persistence;


//TODO  CANNOT RESOLVE tables

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "e_order", schema = "public", catalog = "postgres")
public class EOrderEntity implements Serializable {
    private static final long serialVersionUID = 2822798487527544682L;
    private Integer orderId;
    private String orderNumber;
    private Double sum;
    private String description;
    private CurrencyEntity currency;

    @Id
    @Column(name = "order_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "order_number", nullable = false, length = -1)
    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Basic
    @Column(name = "sum", nullable = false)
    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    @Basic
    @Column(name = "description", nullable = true, length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "currency", nullable = false)
    public CurrencyEntity getCurrency() {
        return currency;
    }


    public void setCurrency(CurrencyEntity currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EOrderEntity that = (EOrderEntity) o;

        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        if (orderNumber != null ? !orderNumber.equals(that.orderNumber) : that.orderNumber != null) return false;
        if (sum != null ? !sum.equals(that.sum) : that.sum != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (currency != null ? !currency.equals(that.currency) : that.currency != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId != null ? orderId.hashCode() : 0;
        result = 31 * result + (orderNumber != null ? orderNumber.hashCode() : 0);
        result = 31 * result + (sum != null ? sum.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        return result;
    }
}
