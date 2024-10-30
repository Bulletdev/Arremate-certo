/*     */ package br.com.arremate.l.l;
/*     */ 
/*     */ import br.com.arremate.f.g;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.j;
/*     */ import java.sql.PreparedStatement;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class a
/*     */   extends g
/*     */ {
/*  17 */   private static final Logger LOG = LoggerFactory.getLogger(a.class);
/*  18 */   private String dP = "";
/*     */   
/*     */   public a(int paramInt, j paramj) {
/*  21 */     super(paramInt, paramj);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ao() {
/*  26 */     String str1 = "liccodigo, porcodigo, empcnpj, itecodigo, itenumero, itedescricao, itequantidade, itemeepp, itevalortotal, itevalorunitario, itetipo, iteposicao";
/*  27 */     String str2 = "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?";
/*  28 */     byte b = 1;
/*     */     
/*  30 */     String str3 = "INSERT INTO tbitemlicitacao(" + str1 + ") VALUES (" + str2 + ")";
/*     */     
/*  32 */     try (PreparedStatement null = br.com.arremate.e.a.a().prepareStatement(str3)) {
/*  33 */       preparedStatement.setInt(b++, a().v());
/*  34 */       preparedStatement.setInt(b++, a().b().v());
/*  35 */       preparedStatement.setLong(b++, a().C());
/*  36 */       preparedStatement.setInt(b++, v());
/*  37 */       preparedStatement.setString(b++, bo());
/*  38 */       preparedStatement.setString(b++, K());
/*  39 */       preparedStatement.setDouble(b++, i());
/*  40 */       preparedStatement.setBoolean(b++, false);
/*  41 */       preparedStatement.setDouble(b++, k());
/*  42 */       preparedStatement.setDouble(b++, j());
/*  43 */       preparedStatement.setInt(b++, w());
/*  44 */       preparedStatement.setInt(b++, j());
/*  45 */       preparedStatement.execute();
/*     */       
/*  47 */       return true;
/*  48 */     } catch (Exception exception) {
/*  49 */       LOG.error("Erro ao inserir item", exception);
/*  50 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean aq() {
/*  56 */     return g.b(bB(), g.aw);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean aM() {
/*  61 */     return (ar() || as());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ar() {
/*  66 */     return (g.b(bB(), g.ax) || g.b(bB(), g.I));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean as() {
/*  71 */     return g.b(bB(), g.ay);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean aw() {
/*  76 */     return (g.b(bB(), g.aD) || 
/*  77 */       g.b(bB(), g.aA) || 
/*  78 */       g.b(bB(), g.aB) || 
/*  79 */       g.b(bB(), g.aC));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean av() {
/*  84 */     return g.b(bB(), g.B);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ax() {
/*  89 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean az() {
/*  94 */     return super.az();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean ay() {
/*  99 */     return false;
/*     */   }
/*     */   
/*     */   public String bu() {
/* 103 */     return this.dP;
/*     */   }
/*     */   
/*     */   public void Y(String paramString) {
/* 107 */     this.dP = paramString;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\l\l\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */