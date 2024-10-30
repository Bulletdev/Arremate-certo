/*     */ package org.apache.poi.poifs.crypt.dsig.services;
/*     */ 
/*     */ import java.security.cert.CRLException;
/*     */ import java.security.cert.X509CRL;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
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
/*     */ 
/*     */ public class RevocationData
/*     */ {
/*  48 */   private final List<byte[]> crls = (List)new ArrayList<byte>();
/*  49 */   private final List<byte[]> ocsps = (List)new ArrayList<byte>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addCRL(byte[] paramArrayOfbyte) {
/*  58 */     this.crls.add(paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addCRL(X509CRL paramX509CRL) {
/*     */     byte[] arrayOfByte;
/*     */     try {
/*  69 */       arrayOfByte = paramX509CRL.getEncoded();
/*  70 */     } catch (CRLException cRLException) {
/*  71 */       throw new IllegalArgumentException("CRL coding error: " + cRLException.getMessage(), cRLException);
/*     */     } 
/*     */     
/*  74 */     addCRL(arrayOfByte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addOCSP(byte[] paramArrayOfbyte) {
/*  83 */     this.ocsps.add(paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<byte[]> getCRLs() {
/*  92 */     return this.crls;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<byte[]> getOCSPs() {
/* 101 */     return this.ocsps;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasOCSPs() {
/* 112 */     return (false == this.ocsps.isEmpty());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasCRLs() {
/* 121 */     return (false == this.crls.isEmpty());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasRevocationDataEntries() {
/* 130 */     return (hasOCSPs() || hasCRLs());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\dsig\services\RevocationData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */