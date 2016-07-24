package datamodels;

import java.io.Serializable;
import java.util.List;
import javax.faces.model.ListDataModel;
import model.Orders;
import org.primefaces.model.SelectableDataModel;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author klaus
 */
public class OrdersDataModel
        extends ListDataModel<Orders>
        implements SelectableDataModel<Orders>, Serializable {

  public OrdersDataModel() {
  }

  public OrdersDataModel(List<Orders> data) {
    super(data);
  }

  @Override
  public Integer getRowKey(Orders o) {
    return o.getPkOrder();
  }

  @Override
  public Orders getRowData(String key) {
    Logger.getLogger("xy").log(Level.INFO, "OrdersDataModel row {0} requested", key); 
    Logger.getLogger("xy").log(Level.INFO, "checking data model:"); 
    List<Orders> orders = (List<Orders>) this.getWrappedData();
    for (Orders order : orders) {
      Logger.getLogger("xy").log(Level.INFO, "OrdersDataModel checks object with key {0}", order.getPkOrder());
      if (order.getPkOrder().toString().trim().equals(key)) {
        Logger.getLogger("xy").log(Level.INFO, "OrdersDataModel returns object with key {0}", key);
        return order;
      }
    }
    return null;
  }
}
