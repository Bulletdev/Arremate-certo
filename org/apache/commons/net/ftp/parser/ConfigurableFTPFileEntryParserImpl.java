/*     */ package org.apache.commons.net.ftp.parser;
/*     */ 
/*     */ import java.text.ParseException;
/*     */ import java.util.Calendar;
/*     */ import org.apache.commons.net.ftp.Configurable;
/*     */ import org.apache.commons.net.ftp.FTPClientConfig;
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
/*     */ 
/*     */ 
/*     */ public abstract class ConfigurableFTPFileEntryParserImpl
/*     */   extends RegexFTPFileEntryParserImpl
/*     */   implements Configurable
/*     */ {
/*     */   private final FTPTimestampParser timestampParser;
/*     */   
/*     */   public ConfigurableFTPFileEntryParserImpl(String paramString) {
/*  55 */     super(paramString);
/*  56 */     this.timestampParser = new FTPTimestampParserImpl();
/*     */   }
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
/*     */   public ConfigurableFTPFileEntryParserImpl(String paramString, int paramInt) {
/*  69 */     super(paramString, paramInt);
/*  70 */     this.timestampParser = new FTPTimestampParserImpl();
/*     */   }
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
/*     */   public Calendar parseTimestamp(String paramString) throws ParseException {
/*  85 */     return this.timestampParser.parseTimestamp(paramString);
/*     */   }
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
/*     */   public void configure(FTPClientConfig paramFTPClientConfig) {
/* 104 */     if (this.timestampParser instanceof Configurable) {
/* 105 */       FTPClientConfig fTPClientConfig = getDefaultConfiguration();
/* 106 */       if (paramFTPClientConfig != null) {
/* 107 */         if (null == paramFTPClientConfig.getDefaultDateFormatStr()) {
/* 108 */           paramFTPClientConfig.setDefaultDateFormatStr(fTPClientConfig.getDefaultDateFormatStr());
/*     */         }
/* 110 */         if (null == paramFTPClientConfig.getRecentDateFormatStr()) {
/* 111 */           paramFTPClientConfig.setRecentDateFormatStr(fTPClientConfig.getRecentDateFormatStr());
/*     */         }
/* 113 */         ((Configurable)this.timestampParser).configure(paramFTPClientConfig);
/*     */       } else {
/* 115 */         ((Configurable)this.timestampParser).configure(fTPClientConfig);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected abstract FTPClientConfig getDefaultConfiguration();
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\ftp\parser\ConfigurableFTPFileEntryParserImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */