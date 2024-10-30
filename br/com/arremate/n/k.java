/*     */ package br.com.arremate.n;
/*     */ import java.awt.Dialog;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.awt.event.ItemEvent;
/*     */ import java.awt.event.ItemListener;
/*     */ import javax.swing.GroupLayout;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JCheckBox;
/*     */ import javax.swing.JDialog;
/*     */ import javax.swing.JEditorPane;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.LayoutStyle;
/*     */ import javax.swing.text.html.HTMLEditorKit;
/*     */ 
/*     */ public class k extends JDialog {
/*     */   private boolean aq;
/*     */   
/*     */   public k() {
/*  21 */     k();
/*  22 */     this.aq = false;
/*  23 */     dB();
/*     */     
/*  25 */     setLocationRelativeTo(null);
/*     */   }
/*     */   private JButton r; private JCheckBox o;
/*     */   private JEditorPane a;
/*     */   private JLabel aV;
/*     */   private JScrollPane g;
/*     */   
/*     */   public void dB() {
/*  33 */     String str = "<html><body><p>Estes Termos e Condições de Uso constituem um acordo legal entre o usuário comprador e a empresa <strong>EFFECTI TECNOLOGIA WEB LTDA</strong>, pessoa jurídica de direito privado, inscrita no CNPJ n° 21.693.016/0001-05, com sede na Rua Herculano Nunes Teixeira, n° 105, Sala 11, Bairro Budag, na cidade de Rio do Sul - SC em que o usuário comprador manifesta sua concordância e aceitação dos Termos. Caso você não concorde com os mesmos, não poderá efetuar seu cadastro e utilizar os serviços exclusivos a usuários cadastrados.</p><p>1 - A empresa <strong>EFFECTI TECNOLOGIA WEB LTDA</strong> é somente desenvolvedora do SOFTWARE para Licitação, não responsabilizando-se por seu uso.</p><p>2 - Fica desde já esclarecido que algumas informações estatísticas do uso do SOFTWARE poderão ser compartilhadas com a empresa EFFECTI.</p><p>3 - O pagamento para uso do SOFTWARE deverá ser antecipado, sendo que o acesso ao mesmo será automaticamente bloqueado após o terceiro dia do vencimento do respectivo boleto.</p><p>4 - O SOFTWARE para Licitação foi desenvolvido para atender as necessidades dos clientes da empresa EFFECTI, sendo vedada sua utilização para propósitos não vinculados à relação de negócios estabelecida nestes Termos e Condições de Uso. Qualquer uso do SOFTWARE, seu conteúdo ou recurso para qualquer finalidade não permitida expressamente por estes Termos levará ao imediato cancelamento de logins e senhas de acesso.</p><p>5 - Fica desde já esclarecido que o uso do SOFTWARE para Licitação até o presente momento não é vedado por qualquer lei ou resolução, sendo que a partir da vigência de qualquer norma proibitiva o acesso ao uso desta ferramenta será imediatamente bloqueada pelo desenvolvedor.</p><p>6 - A empresa EFFECTI não se responsabiliza pela veracidade das informações prestadas pelos usuários do SOFTWARE para Licitação, sendo deles toda a responsabilidade por seu conteúdo, assim como não possui nenhuma relação com a atividade desenvolvida pelos usuários, ficando sua responsabilidade restrita ao desenvolvimento do SOFTWARE para Licitação.</p><p>7 - Fica eleito o Foro da cidade de Rio do Sul - SC, para dirimir quaisquer dúvidas oriundos deste contrato.</p></body></html>";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  72 */     HTMLEditorKit hTMLEditorKit = new HTMLEditorKit();
/*  73 */     hTMLEditorKit.getStyleSheet().addRule("body {text-align: justify; margin: 4px; font-family: Arial;}");
/*     */     
/*  75 */     this.a.setEditorKit(hTMLEditorKit);
/*  76 */     this.a.setEditable(false);
/*  77 */     this.a.setContentType("text/html");
/*  78 */     this.a.setText(str);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void k() {
/*  89 */     this.aV = new JLabel();
/*  90 */     this.o = new JCheckBox();
/*  91 */     this.r = new JButton();
/*  92 */     this.g = new JScrollPane();
/*  93 */     this.a = new JEditorPane();
/*     */     
/*  95 */     setDefaultCloseOperation(2);
/*  96 */     setTitle("Effecti - Disputar");
/*  97 */     setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
/*  98 */     setResizable(false);
/*     */     
/* 100 */     this.aV.setFont(new Font("Calibri", 1, 24));
/* 101 */     this.aV.setHorizontalAlignment(0);
/* 102 */     this.aV.setText("TERMOS E CONDIÇÕES DE USO");
/*     */     
/* 104 */     this.o.setText("Eu li e concordo com os termos de uso");
/* 105 */     this.o.addItemListener(new ItemListener(this) {
/*     */           public void itemStateChanged(ItemEvent param1ItemEvent) {
/* 107 */             k.a(this.a, param1ItemEvent);
/*     */           }
/*     */         });
/*     */     
/* 111 */     this.r.setIcon(new ImageIcon(getClass().getResource("/img/accept.png")));
/* 112 */     this.r.setText("Aceito");
/* 113 */     this.r.setEnabled(false);
/* 114 */     this.r.addActionListener(new ActionListener(this) {
/*     */           public void actionPerformed(ActionEvent param1ActionEvent) {
/* 116 */             k.a(this.a, param1ActionEvent);
/*     */           }
/*     */         });
/*     */     
/* 120 */     this.g.setViewportView(this.a);
/*     */     
/* 122 */     GroupLayout groupLayout = new GroupLayout(getContentPane());
/* 123 */     getContentPane().setLayout(groupLayout);
/* 124 */     groupLayout.setHorizontalGroup(groupLayout
/* 125 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 126 */         .addGroup(groupLayout.createSequentialGroup()
/* 127 */           .addContainerGap()
/* 128 */           .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
/* 129 */             .addComponent(this.g)
/* 130 */             .addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup()
/* 131 */               .addComponent(this.o)
/* 132 */               .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, -1, 32767)
/* 133 */               .addComponent(this.r))
/* 134 */             .addComponent(this.aV, -1, 580, 32767))
/* 135 */           .addContainerGap()));
/*     */     
/* 137 */     groupLayout.setVerticalGroup(groupLayout
/* 138 */         .createParallelGroup(GroupLayout.Alignment.LEADING)
/* 139 */         .addGroup(groupLayout.createSequentialGroup()
/* 140 */           .addContainerGap()
/* 141 */           .addComponent(this.aV)
/* 142 */           .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
/* 143 */           .addComponent(this.g, -1, 256, 32767)
/* 144 */           .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
/* 145 */           .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
/* 146 */             .addComponent(this.r)
/* 147 */             .addComponent(this.o))
/* 148 */           .addContainerGap()));
/*     */ 
/*     */     
/* 151 */     pack();
/*     */   }
/*     */   
/*     */   private void e(ItemEvent paramItemEvent) {
/* 155 */     this.r.setEnabled(this.o.isSelected());
/*     */   }
/*     */   
/*     */   private void y(ActionEvent paramActionEvent) {
/* 159 */     if (g.a().d() != null) {
/* 160 */       this.aq = true;
/* 161 */       dispose();
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean ci() {
/* 166 */     return this.aq;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\n\k.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */