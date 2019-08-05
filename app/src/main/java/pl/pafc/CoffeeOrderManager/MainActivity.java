package pl.pafc.CoffeeOrderManager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int numberOfCoffies = 1;
    int orderNumber = 1;

    List<Order> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        TextView priceTextView = findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(calculatePrice()));
    }

    public void incrementButton(View view) {
        if (numberOfCoffies < 25) {
            numberOfCoffies++;
            displayOrder(numberOfCoffies);
        }
    }

    public void decrementButton(View view) {
        if (numberOfCoffies > 1) {
            numberOfCoffies--;
            displayOrder(numberOfCoffies);
        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayOrder(int number) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText(NumberFormat.getNumberInstance().format(number));
    }

    private int calculatePrice() {
        int summary = 0;
        for (Order aList : list) {
            if (aList.additives.isCandy()) {
                summary += aList.additives.getCandyPrice();
            }
            if (aList.additives.isChocolate()) {
                summary += aList.additives.getChocolatePrice();
            }
            if (aList.additives.isWhippedCream()) {
                summary += aList.additives.getWhippedCreamPrice();
            }
            summary += (aList.quantity * aList.getCoffePrice());
        }

        return summary;
    }

    public boolean addWhippedCream(View view) {
        CheckBox checkBoxWhippedCream = findViewById(R.id.checkboxWhippedCream);
        return checkBoxWhippedCream.isChecked();
    }

    public boolean addChocolate(View view) {
        CheckBox checkBoxChockolade = findViewById(R.id.checkboxChockolade);
        return checkBoxChockolade.isChecked();
    }

    public boolean addCandy(View view) {
        CheckBox checkBoxCandy = findViewById(R.id.checkboxCandy);
        return checkBoxCandy.isChecked();
    }

    public void addOrderToList(View view) {
        addWhippedCream(view);
        addCandy(view);
        addChocolate(view);

        list.add(new Order(numberOfCoffies, new Additives(addWhippedCream(view), addChocolate(view), addCandy(view))));
        displayedList(list);
    }

    public void displayedList(List list) {
        StringBuilder builder = new StringBuilder();
        TextView addOrders = findViewById(R.id.addedOrders);

        for (Object details : list) {
            builder.append(" no." + orderNumber + ": " + details).append("\n");
            orderNumber++;
        }
        orderNumber = 1;
        addOrders.setText(builder.toString());
    }
}