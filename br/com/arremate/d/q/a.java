/*     */ package br.com.arremate.d.q;
/*     */ 
/*     */ import br.com.arremate.d.e;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.j.j;
/*     */ import br.com.arremate.l.m;
/*     */ import br.com.arremate.l.m.b;
/*     */ import br.com.arremate.m.y;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import org.e.i;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class a
/*     */   extends e
/*     */ {
/*     */   private String aj;
/*     */   
/*     */   public a(g paramg, i parami) {
/*  28 */     super(paramg, parami);
/*     */     
/*  30 */     this.aj = "";
/*     */   }
/*     */ 
/*     */   
/*     */   protected List<m> d() {
/*  35 */     ArrayList<m> arrayList = new ArrayList();
/*     */     
/*  37 */     if ("".equals(this.aj)) {
/*  38 */       bn();
/*     */     }
/*     */     
/*  41 */     String str = a().k(this.aj);
/*  42 */     if ("".equals(str)) {
/*  43 */       return arrayList;
/*     */     }
/*     */     
/*  46 */     Document document = Jsoup.parse(str);
/*  47 */     Element element = document.select("table[id=tbMensagemChat] > tbody").first();
/*  48 */     Elements elements = element.select("tr");
/*     */     
/*  50 */     for (int i = elements.size() - 1; i >= 0; i--) {
/*  51 */       Elements elements1 = elements.get(i).select("td");
/*  52 */       if (elements1.size() != 1) {
/*     */ 
/*     */ 
/*     */         
/*  56 */         String[] arrayOfString1 = elements1.get(0).text().replace("(", "").replace(")", "").split(" ");
/*  57 */         String str1 = arrayOfString1[0];
/*  58 */         String[] arrayOfString2 = arrayOfString1[1].split(" ");
/*  59 */         String str2 = arrayOfString2[0];
/*  60 */         String str3 = arrayOfString2[1];
/*  61 */         String str4 = elements1.get(1).text();
/*  62 */         Date date = y.a(str2, str3);
/*     */         
/*  64 */         m m = new m(str4, date, str1);
/*  65 */         if (a(m)) {
/*     */           break;
/*     */         }
/*     */         
/*  69 */         arrayList.add(0, m);
/*     */       } 
/*     */     } 
/*  72 */     return arrayList;
/*     */   }
/*     */   
/*     */   private void bn() {
/*     */     try {
/*  77 */       if (!a().isRunning() && 
/*  78 */         a().z() != 1) {
/*     */         return;
/*     */       }
/*     */ 
/*     */       
/*  83 */       b b = a().a();
/*  84 */       String str1 = a().c(Integer.valueOf(b.v()), Integer.valueOf(b.a().w()));
/*     */       
/*  86 */       if (!"".equals(str1)) {
/*  87 */         i i = new i(str1);
/*  88 */         str1 = i.j("d").getString("Retorno");
/*     */       } 
/*     */       
/*  91 */       if ("".equals(str1)) {
/*     */         return;
/*     */       }
/*     */       
/*  95 */       String str2 = a().F(str1);
/*     */       
/*  97 */       if ("".equals(str2)) {
/*     */         return;
/*     */       }
/*     */       
/* 101 */       String str3 = str2.substring(str2.indexOf("DestacarChat"));
/* 102 */       str3 = str3.substring(str3.indexOf("q=") + 2, str3.indexOf(";"));
/* 103 */       str3 = str3.substring(0, str3.indexOf("'"));
/* 104 */       this.aj = str3;
/*     */       
/*     */       return;
/* 107 */     } catch (Exception exception) {
/* 108 */       a.error("#002 - Failed to load hash chat", exception);
/* 109 */       a().h("#002 - Failed to load hash chat");
/*     */ 
/*     */       
/* 112 */       this.aj = "";
/*     */       return;
/*     */     } 
/*     */   }
/*     */   public j a() {
/* 117 */     return (j)super.a();
/*     */   }
/*     */ 
/*     */   
/*     */   public e a() {
/* 122 */     return (e)super.a();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\q\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */