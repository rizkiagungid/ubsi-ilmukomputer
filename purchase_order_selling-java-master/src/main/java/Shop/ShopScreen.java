/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shop;

import Shop.DataHandler.ItemShopModel;
import Shop.DataHandler.UserDataManager;
import Shop.BuyTableCell.BuyTableCellEditor;
import Shop.BuyTableCell.BuyTableCellRenderer;
import Shop.CartTableCell.CartTableCellRenderer;
import Shop.CartTableCell.CartTableCellEditor;
import Shop.DataHandler.CartModel;
import Shop.DataHandler.PurchaseHistoryModel;
import Shop.HistoryTableCell.HistoryTableCellEditor;
import Shop.HistoryTableCell.HistoryTableCellRenderer;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author ASUS
 */
public class ShopScreen extends javax.swing.JFrame {

    /**
     * Creates new form MenuScreen
     */
    void popUp(String itemName) {
        JOptionPane.showMessageDialog(this, itemName + " is added to cart");
    }

    //custom variable declaration
    static public ArrayList<ItemShopModel> storedItems = new ArrayList<ItemShopModel>();
    static boolean isInitData = true;
    int quantityItemCount = 0;
    int totalSellPrice = 0;
    int rowHeight = 60;

    public void login() {
        UserDataManager.isLogin = true;
        userAccountButton.setText("Logout");
        userNameLabel.setText("Hi " + UserDataManager.getCurrentUserName() + "!");
    }

    public void logout() {
        UserDataManager.isLogin = false;
        new LoginScreen().setVisible(true);
        this.setVisible(false);
        this.dispose();
    }

    public void updatetTotalMoney() {
        if (itemNameField.getText().isBlank() == false && priceField.getText().isBlank() == false && priceField.getText().matches("[0-9]+")) {
            int price = Integer.parseInt(priceField.getText());
            totalSellPrice = price * quantityItemCount;
            totalPrice.setText(String.valueOf(totalSellPrice));
        }
    }

    public void resetSellFormField() {
        quantityItemCount = 0;
        totalSellPrice = 0;
        itemNameField.setText("");
        priceField.setText("");
        totalPrice.setText("0");
        quantityTextField.setText("0");
        buildBuyTable();
    }

    private void initApp() {
        if (isInitData) {
            storedItems.add(new ItemShopModel("initItem1", "Laptop", "1000", "10"));
            storedItems.add(new ItemShopModel("initItem2", "Smartphone", "500", "10"));
            storedItems.add(new ItemShopModel("initItem3", "Headphone", "200", "10"));
            storedItems.add(new ItemShopModel("initItem4", "Keyboard", "100", "10"));
            isInitData = false;
        }
        buildBuyTable();
        buildCartTable();
        buildHistoryTable();
    }

    public void buildBuyTable() {
        itemTable.setModel(new TableModel(storedItems.size(), "Product", ItemShopModel.class));
        itemTable.setDefaultRenderer(ItemShopModel.class, new BuyTableCellRenderer(storedItems, this));
        itemTable.setDefaultEditor(ItemShopModel.class, new BuyTableCellEditor(storedItems, this));
        itemTable.setRowHeight(rowHeight);
    }

    public void buildCartTable() {
        //TODO Cart table cell with delete button
        cartTable.setModel(new TableModel(UserDataManager.getCurrentUserCartSize(), "Your Cart", CartModel.class));
        cartTable.setDefaultRenderer(CartModel.class, new CartTableCellRenderer(UserDataManager.getCurrentUserCartData(), this));
        cartTable.setDefaultEditor(CartModel.class, new CartTableCellEditor(UserDataManager.getCurrentUserCartData(), this));
        cartTable.setRowHeight(rowHeight);
        totalPriceCart.setText("$ " + String.valueOf(UserDataManager.getTotalPriceItemsInCurrentUserCart()));
    }

    public void buildHistoryTable() {
        //TODO print paid cart on table wihtout any button
        purchaseHistoryTable.setModel(new TableModel(UserDataManager.getCurrentUserHistorySize(), "Your History", PurchaseHistoryModel.class));
        purchaseHistoryTable.setDefaultRenderer(PurchaseHistoryModel.class, new HistoryTableCellRenderer(UserDataManager.getCurrentUserHistoryData()));
        purchaseHistoryTable.setDefaultEditor(PurchaseHistoryModel.class, new HistoryTableCellEditor(UserDataManager.getCurrentUserHistoryData()));
        purchaseHistoryTable.setRowHeight(rowHeight);

    }

    public ShopScreen() {

        this.setMinimumSize(new Dimension(1280, 720));
        initComponents();
        quantityTextField.setText(String.valueOf(quantityItemCount));
        initApp();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        navBar = new javax.swing.JPanel();
        userNameLabel = new javax.swing.JLabel();
        userAccountButton = new javax.swing.JButton();
        jTabbedPane = new javax.swing.JTabbedPane();
        buyPanel = new javax.swing.JPanel();
        buyTableScrollPanel = new javax.swing.JScrollPane();
        itemTable = new javax.swing.JTable();
        sellPanel = new javax.swing.JPanel();
        cartTitle = new javax.swing.JLabel();
        quantityLabel = new javax.swing.JLabel();
        reduceQuantity3 = new javax.swing.JButton();
        increaseQuantity = new javax.swing.JButton();
        totalPriceLabel = new javax.swing.JLabel();
        totalPrice = new javax.swing.JLabel();
        itemNameField = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        sellButton = new javax.swing.JButton();
        priceField = new javax.swing.JTextField();
        priceLabel = new javax.swing.JLabel();
        resetFormButton = new javax.swing.JButton();
        quantityTextField = new javax.swing.JTextField();
        cartPanel = new javax.swing.JPanel();
        cartScrollPanel1 = new javax.swing.JScrollPane();
        cartTable = new javax.swing.JTable();
        checkoutBar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        totalPriceCart = new javax.swing.JLabel();
        checkoutButton = new javax.swing.JButton();
        historyPanel = new javax.swing.JPanel();
        purchaseHistoryScrollPanel = new javax.swing.JScrollPane();
        purchaseHistoryTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        navBar.setBackground(new java.awt.Color(0, 0, 0));
        navBar.setForeground(new java.awt.Color(255, 255, 255));

        userNameLabel.setBackground(new java.awt.Color(0, 0, 0));
        userNameLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        userNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        userNameLabel.setText("Hello!");

        userAccountButton.setBackground(new java.awt.Color(0, 0, 0));
        userAccountButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        userAccountButton.setForeground(new java.awt.Color(255, 255, 255));
        userAccountButton.setText("Login");
        userAccountButton.setBorder(null);
        userAccountButton.setBorderPainted(false);
        userAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userAccountButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout navBarLayout = new javax.swing.GroupLayout(navBar);
        navBar.setLayout(navBarLayout);
        navBarLayout.setHorizontalGroup(
            navBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(userAccountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        navBarLayout.setVerticalGroup(
            navBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(navBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userNameLabel)
                    .addComponent(userAccountButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPaneStateChanged(evt);
            }
        });
        jTabbedPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPaneMouseClicked(evt);
            }
        });

        itemTable.setBackground(new java.awt.Color(153, 153, 153));
        itemTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        itemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        itemTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemTableMouseClicked(evt);
            }
        });
        buyTableScrollPanel.setViewportView(itemTable);

        javax.swing.GroupLayout buyPanelLayout = new javax.swing.GroupLayout(buyPanel);
        buyPanel.setLayout(buyPanelLayout);
        buyPanelLayout.setHorizontalGroup(
            buyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buyTableScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1275, Short.MAX_VALUE)
        );
        buyPanelLayout.setVerticalGroup(
            buyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buyPanelLayout.createSequentialGroup()
                .addComponent(buyTableScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Buy", buyPanel);

        cartTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        cartTitle.setText("Sell Your Items");

        quantityLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        quantityLabel.setForeground(new java.awt.Color(51, 51, 51));
        quantityLabel.setText("Quantity");

        reduceQuantity3.setBackground(new java.awt.Color(0, 0, 0));
        reduceQuantity3.setForeground(new java.awt.Color(255, 255, 255));
        reduceQuantity3.setText("-");
        reduceQuantity3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reduceQuantity3ActionPerformed(evt);
            }
        });

        increaseQuantity.setBackground(new java.awt.Color(0, 0, 0));
        increaseQuantity.setForeground(new java.awt.Color(255, 255, 255));
        increaseQuantity.setText("+");
        increaseQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                increaseQuantityActionPerformed(evt);
            }
        });

        totalPriceLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        totalPriceLabel.setForeground(new java.awt.Color(51, 51, 51));
        totalPriceLabel.setText("Total money you'll get");

        totalPrice.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        totalPrice.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        totalPrice.setText("0");

        itemNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNameFieldActionPerformed(evt);
            }
        });

        nameLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(51, 51, 51));
        nameLabel.setText("Name");

        sellButton.setBackground(new java.awt.Color(0, 0, 0));
        sellButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sellButton.setForeground(new java.awt.Color(255, 255, 255));
        sellButton.setText("Sell");
        sellButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellButtonActionPerformed(evt);
            }
        });

        priceField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceFieldActionPerformed(evt);
            }
        });

        priceLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        priceLabel.setForeground(new java.awt.Color(51, 51, 51));
        priceLabel.setText("Price $");

        resetFormButton.setBackground(new java.awt.Color(0, 0, 0));
        resetFormButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        resetFormButton.setForeground(new java.awt.Color(255, 255, 255));
        resetFormButton.setText("Reset");
        resetFormButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetFormButtonActionPerformed(evt);
            }
        });

        quantityTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        quantityTextField.setText("0");
        quantityTextField.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                quantityTextFieldInputMethodTextChanged(evt);
            }
        });
        quantityTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityTextFieldActionPerformed(evt);
            }
        });
        quantityTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                quantityTextFieldKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout sellPanelLayout = new javax.swing.GroupLayout(sellPanel);
        sellPanel.setLayout(sellPanelLayout);
        sellPanelLayout.setHorizontalGroup(
            sellPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sellPanelLayout.createSequentialGroup()
                .addContainerGap(527, Short.MAX_VALUE)
                .addGroup(sellPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sellButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cartTitle)
                    .addComponent(nameLabel)
                    .addComponent(priceLabel)
                    .addGroup(sellPanelLayout.createSequentialGroup()
                        .addComponent(reduceQuantity3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(quantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(increaseQuantity))
                    .addComponent(priceField)
                    .addComponent(itemNameField)
                    .addComponent(quantityLabel)
                    .addComponent(totalPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalPriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resetFormButton, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(448, 448, 448))
        );
        sellPanelLayout.setVerticalGroup(
            sellPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sellPanelLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(cartTitle)
                .addGap(50, 50, 50)
                .addComponent(nameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(itemNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(priceLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(quantityLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sellPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reduceQuantity3)
                    .addComponent(increaseQuantity)
                    .addComponent(quantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(totalPriceLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalPrice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sellButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(resetFormButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(168, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Sell", sellPanel);

        cartTable.setBackground(new java.awt.Color(153, 153, 153));
        cartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        cartTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartTableMouseClicked(evt);
            }
        });
        cartScrollPanel1.setViewportView(cartTable);

        checkoutBar.setBackground(new java.awt.Color(0, 0, 0));
        checkoutBar.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Total Price:");

        totalPriceCart.setBackground(new java.awt.Color(0, 0, 0));
        totalPriceCart.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        totalPriceCart.setForeground(new java.awt.Color(255, 255, 255));
        totalPriceCart.setText("$ 0");

        checkoutButton.setBackground(new java.awt.Color(0, 0, 0));
        checkoutButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        checkoutButton.setForeground(new java.awt.Color(255, 255, 255));
        checkoutButton.setText("Checkout");
        checkoutButton.setBorder(null);
        checkoutButton.setBorderPainted(false);
        checkoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout checkoutBarLayout = new javax.swing.GroupLayout(checkoutBar);
        checkoutBar.setLayout(checkoutBarLayout);
        checkoutBarLayout.setHorizontalGroup(
            checkoutBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, checkoutBarLayout.createSequentialGroup()
                .addContainerGap(817, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(totalPriceCart, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(checkoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
        );
        checkoutBarLayout.setVerticalGroup(
            checkoutBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(checkoutBarLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(checkoutBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(checkoutBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(totalPriceCart, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout cartPanelLayout = new javax.swing.GroupLayout(cartPanel);
        cartPanel.setLayout(cartPanelLayout);
        cartPanelLayout.setHorizontalGroup(
            cartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(checkoutBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cartScrollPanel1)
        );
        cartPanelLayout.setVerticalGroup(
            cartPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cartPanelLayout.createSequentialGroup()
                .addComponent(cartScrollPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkoutBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane.addTab("Cart", cartPanel);

        purchaseHistoryTable.setBackground(new java.awt.Color(153, 153, 153));
        purchaseHistoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        purchaseHistoryScrollPanel.setViewportView(purchaseHistoryTable);

        javax.swing.GroupLayout historyPanelLayout = new javax.swing.GroupLayout(historyPanel);
        historyPanel.setLayout(historyPanelLayout);
        historyPanelLayout.setHorizontalGroup(
            historyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(purchaseHistoryScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1275, Short.MAX_VALUE)
        );
        historyPanelLayout.setVerticalGroup(
            historyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(purchaseHistoryScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
        );

        jTabbedPane.addTab("History", historyPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(navBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(navBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userAccountButtonActionPerformed
        if (UserDataManager.isLogin == false) {
            new LoginScreen().setVisible(true);
            this.setVisible(false);
            this.dispose();
        } else {
            logout();
        }
    }//GEN-LAST:event_userAccountButtonActionPerformed

    private void priceFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceFieldActionPerformed

    }//GEN-LAST:event_priceFieldActionPerformed

    private void itemNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNameFieldActionPerformed

    }//GEN-LAST:event_itemNameFieldActionPerformed

    private void reduceQuantity3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reduceQuantity3ActionPerformed
        // decrease quantity
        if (!(quantityItemCount <= 0)) {
            quantityItemCount--;
            quantityTextField.setText(String.valueOf(quantityItemCount));
        }
        //update total price if all field is filled
        updatetTotalMoney();

    }//GEN-LAST:event_reduceQuantity3ActionPerformed

    private void itemTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemTableMouseClicked

    }//GEN-LAST:event_itemTableMouseClicked

    private void sellButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sellButtonActionPerformed
        //check is the user login   
        //check is all required field is not empty
        //check is priceField only contain number
        // get nameItem, PriceItem, QuantityItem -> store it inside storedItem arrayList;
        // popup message successfull selling item
        //sent selling data to payment history
        //sent current date and time

        //get all text
        String itemName = itemNameField.getText();
        String itemPrice = priceField.getText();
        //store inside storedItem List

        if (UserDataManager.isLogin == false) {
            JOptionPane.showMessageDialog(this, "You need to login first");
        } else if (itemName.isBlank() || itemPrice.isBlank()) {
            JOptionPane.showMessageDialog(this, "Please don't leave empty field!");
        } else if (itemPrice.matches("[0-9]+") == false) {
            JOptionPane.showMessageDialog(this, "Numbers only on Price field");
        } else if (quantityItemCount == 0) {
            JOptionPane.showMessageDialog(this, "Quantity must not be 0");
        } else {
            String date = UserDataManager.getCurrentDateAndTime();
            storedItems.add(new ItemShopModel(UserDataManager.getCurrentDateAndTime(), itemName, itemPrice, String.valueOf(quantityItemCount)));
            JOptionPane.showMessageDialog(this, "Item is added to store");
            UserDataManager.addHistoryToCurrentUserHistoryData(itemName, itemPrice, String.valueOf(quantityItemCount), date, "SELL");
            //reset
            resetSellFormField();
            buildHistoryTable();
            buildBuyTable();
        }

    }//GEN-LAST:event_sellButtonActionPerformed

    private void increaseQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_increaseQuantityActionPerformed
        //increase quanitiy
        quantityItemCount++;
        quantityTextField.setText(String.valueOf(quantityItemCount));
        // update
        updatetTotalMoney();
    }//GEN-LAST:event_increaseQuantityActionPerformed

    private void resetFormButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetFormButtonActionPerformed
        resetSellFormField();
    }//GEN-LAST:event_resetFormButtonActionPerformed

    private void checkoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutButtonActionPerformed
        //sent all cart data item into history user
        //clear all cart data
        //add current date and time
        if (UserDataManager.getTotalPriceItemsInCurrentUserCart() > 0) {
            if (UserDataManager.getCurrentUserCartSize() != 0) {
                String date = UserDataManager.getCurrentDateAndTime();
                for (int i = 0; i < UserDataManager.getCurrentUserCartSize(); i++) {
                    String totalQuantity = String.valueOf(UserDataManager.getCurrentUserCartData().get(i).buyQuantity);
                    String totalPaidPrice = String.valueOf(UserDataManager.getCurrentUserCartData().get(i).price);
                    String itemName = UserDataManager.getCurrentUserCartData().get(i).itemName;
                    UserDataManager.addHistoryToCurrentUserHistoryData(itemName, totalPaidPrice, totalQuantity, date, "BUY");
                }
                JOptionPane.showMessageDialog(this, "Payment Successfull!");
                //decrease quantity or delete item(if item 0) after buy the item
                for (int iStoredItem = 0; iStoredItem < storedItems.size(); iStoredItem++) {
                    for (int iUserCart = 0; iUserCart < UserDataManager.getCurrentUserCartData().size(); iUserCart++) {
                        if (storedItems.get(iStoredItem).id.equals(UserDataManager.getCurrentUserCartData().get(iUserCart).id)) {

                            int itemQuantity = Integer.parseInt(storedItems.get(iStoredItem).quantity);
                            int buyItemQuantity = UserDataManager.getCurrentUserCartData().get(iUserCart).buyQuantity;

                            //new quantity
                            storedItems.get(iStoredItem).quantity = String.valueOf(itemQuantity - buyItemQuantity);
                            // delete if quantity 0
                            if (Integer.parseInt(storedItems.get(iStoredItem).quantity) <= 0) {
                                storedItems.remove(iStoredItem);
                            }
                        }

                    }

                }
            }
            UserDataManager.getCurrentUserCartData().clear();
            //reset quantity counter state back to 1
            for (int i = 0; i < storedItems.size(); i++) {
                storedItems.get(i).quantityCounterState = 1;
            }

            buildCartTable();
            buildHistoryTable();
            buildBuyTable();
        }


    }//GEN-LAST:event_checkoutButtonActionPerformed

    private void jTabbedPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPaneMouseClicked

    }//GEN-LAST:event_jTabbedPaneMouseClicked

    private void jTabbedPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPaneStateChanged


    }//GEN-LAST:event_jTabbedPaneStateChanged

    private void cartTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartTableMouseClicked


    }//GEN-LAST:event_cartTableMouseClicked

    private void quantityTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityTextFieldActionPerformed

    }//GEN-LAST:event_quantityTextFieldActionPerformed

    private void quantityTextFieldInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_quantityTextFieldInputMethodTextChanged

    }//GEN-LAST:event_quantityTextFieldInputMethodTextChanged

    private void quantityTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityTextFieldKeyTyped
        if (quantityTextField.getText().matches("[0-9]+")) {
            quantityItemCount = Integer.parseInt(quantityTextField.getText());
            updatetTotalMoney();
        } else {
            quantityTextField.setText(String.valueOf(quantityItemCount));
        }

    }//GEN-LAST:event_quantityTextFieldKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ShopScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShopScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShopScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShopScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShopScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel buyPanel;
    private javax.swing.JScrollPane buyTableScrollPanel;
    private javax.swing.JPanel cartPanel;
    private javax.swing.JScrollPane cartScrollPanel1;
    private javax.swing.JTable cartTable;
    private javax.swing.JLabel cartTitle;
    private javax.swing.JPanel checkoutBar;
    private javax.swing.JButton checkoutButton;
    private javax.swing.JPanel historyPanel;
    private javax.swing.JButton increaseQuantity;
    private javax.swing.JTextField itemNameField;
    private javax.swing.JTable itemTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JPanel navBar;
    private javax.swing.JTextField priceField;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JScrollPane purchaseHistoryScrollPanel;
    private javax.swing.JTable purchaseHistoryTable;
    private javax.swing.JLabel quantityLabel;
    private javax.swing.JTextField quantityTextField;
    private javax.swing.JButton reduceQuantity3;
    private javax.swing.JButton resetFormButton;
    private javax.swing.JButton sellButton;
    private javax.swing.JPanel sellPanel;
    private javax.swing.JLabel totalPrice;
    private javax.swing.JLabel totalPriceCart;
    private javax.swing.JLabel totalPriceLabel;
    private javax.swing.JButton userAccountButton;
    private javax.swing.JLabel userNameLabel;
    // End of variables declaration//GEN-END:variables
}
