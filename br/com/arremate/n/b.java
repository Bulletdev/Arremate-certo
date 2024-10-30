/*     */ package br.com.arremate.n;
/*     */ import br.com.arremate.m.y;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.FocusEvent;
/*     */ import java.awt.event.KeyAdapter;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.text.DecimalFormat;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFormattedTextField;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.KeyStroke;
/*     */ import javax.swing.LayoutStyle;
/*     */ 
/*     */ public class b extends JDialog {
/*  18 */   private static final Logger a = LoggerFactory.getLogger(b.class); private double l; private JButton i; private JLabel V;
/*     */   private JLabel W;
/*     */   private JFormattedTextField d;
/*     */   
/*     */   public b() {
/*  23 */     super((Window)null, Dialog.ModalityType.TOOLKIT_MODAL);
/*  24 */     k();
/*  25 */     l();
/*  26 */     dg();
/*  27 */     this.l = -1.0D;
/*  28 */     this.d.setText("0,00");
/*     */   }
/*     */   
/*     */   private void l() {
/*  32 */     KeyStroke keyStroke = KeyStroke.getKeyStroke(27, 0);
/*  33 */     byte b1 = 2;
/*  34 */     getRootPane().registerKeyboardAction(paramActionEvent -> dispose(), keyStroke, b1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void dg() {
/*  41 */     setLocationRelativeTo(null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void k() {
/*  48 */     this.W = new JLabel();
/*  49 */     this.i = new JButton();
/*  50 */     this.V = new JLabel();
/*  51 */     this.d = new JFormattedTextField();
/*     */     
/*  53 */     setDefaultCloseOperation(2);
/*  54 */     setTitle("Effecti - Alterar Limite");
/*  55 */     setResizable(false);
/*     */     
/*  57 */     this.W.setText("Valor");
/*     */     
/*  59 */     this.i.setText("Alterar");
/*  60 */     this.i.addActionListener(new ActionListener(this) {
/*     */           public void actionPerformed(ActionEvent param1ActionEvent) {
/*  62 */             b.a(this.a, param1ActionEvent);
/*     */           }
/*     */         });
/*     */     
/*  66 */     this.V.setFont(new Font("Dialog", 1, 10));
/*  67 */     this.V.setText("O valor será aplicado a todos os itens selecionados");
/*     */     
/*  69 */     this.d.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(new DecimalFormat("###,###,###,##0.0000"))));
/*  70 */     this.d.setHorizontalAlignment(4);
/*  71 */     this.d.setText("0,0000");
/*  72 */     this.d.addFocusListener(new FocusAdapter(this) {
/*     */           public void focusGained(FocusEvent param1FocusEvent) {
/*  74 */             b.a(this.a, param1FocusEvent);
/*     */           }
/*     */         });
/*  77 */     this.d.addKeyListener(new KeyAdapter(this) {
/*     */           public void keyReleased(KeyEvent param1KeyEvent) {
/*  79 */             b.a(this.a, param1KeyEvent);
/*     */           }
/*     */         });
/*     */     
/*  83 */     GroupLayout groupLayout = new GroupLayout(getContentPane());
/*  84 */     getContentPane().setLayout(groupLayout);
/*  85 */     groupLayout.setHorizontalGroup(groupLayout
/*  86 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/*  87 */         .addGroup(groupLayout.createSequentialGroup()
/*  88 */           .addContainerGap()
/*  89 */           .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
/*  90 */             .addGroup(groupLayout.createSequentialGroup()
/*  91 */               .addComponent(this.W)
/*  92 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/*  93 */               .addComponent(this.d, -2, 150, -2)
/*  94 */               .addGap(3, 3, 3)
/*  95 */               .addComponent(this.i))
/*  96 */             .addComponent(this.V))
/*  97 */           .addContainerGap(-1, 32767)));
/*     */     
/*  99 */     groupLayout.setVerticalGroup(groupLayout
/* 100 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 101 */         .addGroup(groupLayout.createSequentialGroup()
/* 102 */           .addGap(15, 15, 15)
/* 103 */           .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 104 */             .addComponent(this.W)
/* 105 */             .addComponent(this.i)
/* 106 */             .addComponent(this.d, -2, -1, -2))
/* 107 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 108 */           .addComponent(this.V)
/* 109 */           .addContainerGap(16, 32767)));
/*     */ 
/*     */     
/* 112 */     pack();
/*     */   }
/*     */   
/*     */   private void j(ActionEvent paramActionEvent) {
/*     */     try {
/* 117 */       double d = Double.parseDouble(y.Q(this.d.getText()));
/* 118 */       DecimalFormat decimalFormat = y.a("###,###,###,##0.0000");
/*     */       
/* 120 */       String str = "Você confirma a alteração para o valor de R$" + decimalFormat.format(d);
/* 121 */       a.info(str);
/* 122 */       int i = JOptionPane.showConfirmDialog(this, str, "Alerta", 0, 2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 130 */       if (i == 1) {
/* 131 */         a.info("Rejeitou alteração de valor limite");
/* 132 */         this.d.requestFocusInWindow();
/*     */         
/*     */         return;
/*     */       } 
/* 136 */       this.l = d;
/* 137 */       dispose();
/* 138 */     } catch (Exception exception) {
/* 139 */       JOptionPane.showMessageDialog(this, "Não foi possível alterar, verifique o valor e tente novamente");
/* 140 */       a.warn("Não foi possível alterar, verifique o valor e tente novamente", exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void f(FocusEvent paramFocusEvent) {
/* 145 */     this.d.selectAll();
/*     */   }
/*     */   
/*     */   private void b(KeyEvent paramKeyEvent) {
/* 149 */     if (paramKeyEvent.getKeyCode() == 10) {
/* 150 */       this.i.doClick();
/*     */     }
/*     */   }
/*     */   
/*     */   public double l() {
/* 155 */     return this.l;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\n\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */