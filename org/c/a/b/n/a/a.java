/*    */ package org.c.a.b.n.a;
/*    */ 
/*    */ import android.content.res.AssetManager;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStreamReader;
/*    */ import java.io.Reader;
/*    */ import java.nio.charset.Charset;
/*    */ import org.c.a.a.b;
/*    */ import org.c.a.b.j.b;
/*    */ import org.c.a.b.j.d;
/*    */ import org.c.a.b.n.a;
/*    */ import org.c.a.b.r.c;
/*    */ import org.c.a.b.r.h;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class a
/*    */   extends a
/*    */ {
/*    */   private final AssetManager a;
/*    */   private final String fileName;
/*    */   private final String lD;
/*    */   private final String lE;
/*    */   private final Charset encoding;
/*    */   
/*    */   public a(b paramb, AssetManager paramAssetManager, String paramString1, String paramString2, Charset paramCharset) {
/* 42 */     this.a = paramAssetManager;
/* 43 */     this.lD = paramString1 + "/" + paramString2;
/* 44 */     this.fileName = paramString2;
/* 45 */     this
/*    */       
/* 47 */       .lE = paramb.getPath().isEmpty() ? this.lD : this.lD.substring(paramb.getPath().length() + 1);
/* 48 */     this.encoding = paramCharset;
/*    */   }
/*    */ 
/*    */   
/*    */   public String eK() {
/* 53 */     return this.lE;
/*    */   }
/*    */ 
/*    */   
/*    */   public String eI() {
/* 58 */     return this.lD;
/*    */   }
/*    */ 
/*    */   
/*    */   public String eJ() {
/* 63 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public d a() {
/*    */     try {
/* 69 */       return (d)new b((Reader)new c(new InputStreamReader(this.a.open(this.lD), this.encoding)));
/* 70 */     } catch (IOException iOException) {
/* 71 */       throw new org.c.a.a.a("Unable to load asset: " + eI(), iOException);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public byte[] r() {
/*    */     try {
/* 78 */       return h.a(this.a.open(this.lD));
/* 79 */     } catch (IOException iOException) {
/* 80 */       throw new org.c.a.a.a("Unable to load asset: " + this.lD, iOException);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public String getFilename() {
/* 86 */     return this.fileName;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\n\a\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */