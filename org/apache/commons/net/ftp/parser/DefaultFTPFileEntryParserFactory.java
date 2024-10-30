/*     */ package org.apache.commons.net.ftp.parser;
/*     */ 
/*     */ import java.util.Locale;
/*     */ import java.util.regex.Pattern;
/*     */ import org.apache.commons.net.ftp.FTPClientConfig;
/*     */ import org.apache.commons.net.ftp.FTPFileEntryParser;
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
/*     */ public class DefaultFTPFileEntryParserFactory
/*     */   implements FTPFileEntryParserFactory
/*     */ {
/*     */   private static final String JAVA_IDENTIFIER = "\\p{javaJavaIdentifierStart}(\\p{javaJavaIdentifierPart})*";
/*     */   private static final String JAVA_QUALIFIED_NAME = "(\\p{javaJavaIdentifierStart}(\\p{javaJavaIdentifierPart})*\\.)+\\p{javaJavaIdentifierStart}(\\p{javaJavaIdentifierPart})*";
/*  46 */   private static final Pattern JAVA_QUALIFIED_NAME_PATTERN = Pattern.compile("(\\p{javaJavaIdentifierStart}(\\p{javaJavaIdentifierPart})*\\.)+\\p{javaJavaIdentifierStart}(\\p{javaJavaIdentifierPart})*");
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
/*     */ 
/*     */   
/*     */   public FTPFileEntryParser createFileEntryParser(String paramString) {
/*  91 */     if (paramString == null) {
/*  92 */       throw new ParserInitializationException("Parser key cannot be null");
/*     */     }
/*  94 */     return createFileEntryParser(paramString, null);
/*     */   }
/*     */   
/*     */   private FTPFileEntryParser createFileEntryParser(String paramString, FTPClientConfig paramFTPClientConfig) {
/*     */     UnixFTPEntryParser unixFTPEntryParser;
/*  99 */     FTPFileEntryParser fTPFileEntryParser = null;
/*     */ 
/*     */     
/* 102 */     if (JAVA_QUALIFIED_NAME_PATTERN.matcher(paramString).matches()) {
/*     */       
/*     */       try {
/* 105 */         Class<?> clazz = Class.forName(paramString);
/*     */         try {
/* 107 */           fTPFileEntryParser = (FTPFileEntryParser)clazz.newInstance();
/* 108 */         } catch (ClassCastException classCastException) {
/* 109 */           throw new ParserInitializationException(clazz.getName() + " does not implement the interface org.apache.commons.net.ftp.FTPFileEntryParser.", classCastException);
/*     */         
/*     */         }
/* 112 */         catch (Exception|ExceptionInInitializerError exception) {
/* 113 */           throw new ParserInitializationException("Error initializing parser", exception);
/*     */         } 
/* 115 */       } catch (ClassNotFoundException classNotFoundException) {}
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 120 */     if (fTPFileEntryParser == null) {
/* 121 */       String str = paramString.toUpperCase(Locale.ENGLISH);
/* 122 */       if (str.indexOf("UNIX_LTRIM") >= 0) {
/*     */         
/* 124 */         unixFTPEntryParser = new UnixFTPEntryParser(paramFTPClientConfig, true);
/*     */       
/*     */       }
/* 127 */       else if (str.indexOf("UNIX") >= 0) {
/*     */         
/* 129 */         unixFTPEntryParser = new UnixFTPEntryParser(paramFTPClientConfig, false);
/*     */       }
/* 131 */       else if (str.indexOf("VMS") >= 0) {
/*     */         
/* 133 */         VMSVersioningFTPEntryParser vMSVersioningFTPEntryParser = new VMSVersioningFTPEntryParser(paramFTPClientConfig);
/*     */       }
/* 135 */       else if (str.indexOf("WINDOWS") >= 0) {
/*     */         
/* 137 */         fTPFileEntryParser = createNTFTPEntryParser(paramFTPClientConfig);
/*     */       }
/* 139 */       else if (str.indexOf("OS/2") >= 0) {
/*     */         
/* 141 */         OS2FTPEntryParser oS2FTPEntryParser = new OS2FTPEntryParser(paramFTPClientConfig);
/*     */       }
/* 143 */       else if (str.indexOf("OS/400") >= 0 || str
/* 144 */         .indexOf("AS/400") >= 0) {
/*     */         
/* 146 */         fTPFileEntryParser = createOS400FTPEntryParser(paramFTPClientConfig);
/*     */       }
/* 148 */       else if (str.indexOf("MVS") >= 0) {
/*     */         
/* 150 */         MVSFTPEntryParser mVSFTPEntryParser = new MVSFTPEntryParser();
/*     */       }
/* 152 */       else if (str.indexOf("NETWARE") >= 0) {
/*     */         
/* 154 */         NetwareFTPEntryParser netwareFTPEntryParser = new NetwareFTPEntryParser(paramFTPClientConfig);
/*     */       }
/* 156 */       else if (str.indexOf("MACOS PETER") >= 0) {
/*     */         
/* 158 */         MacOsPeterFTPEntryParser macOsPeterFTPEntryParser = new MacOsPeterFTPEntryParser(paramFTPClientConfig);
/*     */       }
/* 160 */       else if (str.indexOf("TYPE: L8") >= 0) {
/*     */ 
/*     */ 
/*     */         
/* 164 */         unixFTPEntryParser = new UnixFTPEntryParser(paramFTPClientConfig);
/*     */       }
/*     */       else {
/*     */         
/* 168 */         throw new ParserInitializationException("Unknown parser type: " + paramString);
/*     */       } 
/*     */     } 
/*     */     
/* 172 */     if (unixFTPEntryParser instanceof org.apache.commons.net.ftp.Configurable) {
/* 173 */       unixFTPEntryParser.configure(paramFTPClientConfig);
/*     */     }
/* 175 */     return (FTPFileEntryParser)unixFTPEntryParser;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FTPFileEntryParser createFileEntryParser(FTPClientConfig paramFTPClientConfig) throws ParserInitializationException {
/* 203 */     String str = paramFTPClientConfig.getServerSystemKey();
/* 204 */     return createFileEntryParser(str, paramFTPClientConfig);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FTPFileEntryParser createUnixFTPEntryParser() {
/* 210 */     return (FTPFileEntryParser)new UnixFTPEntryParser();
/*     */   }
/*     */ 
/*     */   
/*     */   public FTPFileEntryParser createVMSVersioningFTPEntryParser() {
/* 215 */     return (FTPFileEntryParser)new VMSVersioningFTPEntryParser();
/*     */   }
/*     */   
/*     */   public FTPFileEntryParser createNetwareFTPEntryParser() {
/* 219 */     return (FTPFileEntryParser)new NetwareFTPEntryParser();
/*     */   }
/*     */ 
/*     */   
/*     */   public FTPFileEntryParser createNTFTPEntryParser() {
/* 224 */     return createNTFTPEntryParser(null);
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
/*     */   private FTPFileEntryParser createNTFTPEntryParser(FTPClientConfig paramFTPClientConfig) {
/* 236 */     if (paramFTPClientConfig != null && "WINDOWS".equals(paramFTPClientConfig
/* 237 */         .getServerSystemKey()))
/*     */     {
/* 239 */       return (FTPFileEntryParser)new NTFTPEntryParser(paramFTPClientConfig);
/*     */     }
/*     */     
/* 242 */     FTPClientConfig fTPClientConfig = (paramFTPClientConfig != null) ? new FTPClientConfig(paramFTPClientConfig) : null;
/* 243 */     return (FTPFileEntryParser)new CompositeFileEntryParser(new FTPFileEntryParser[] { (FTPFileEntryParser)new NTFTPEntryParser(paramFTPClientConfig), (FTPFileEntryParser)new UnixFTPEntryParser(fTPClientConfig, (fTPClientConfig != null && "UNIX_LTRIM"
/*     */ 
/*     */ 
/*     */             
/* 247 */             .equals(fTPClientConfig.getServerSystemKey()))) });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FTPFileEntryParser createOS2FTPEntryParser() {
/* 253 */     return (FTPFileEntryParser)new OS2FTPEntryParser();
/*     */   }
/*     */ 
/*     */   
/*     */   public FTPFileEntryParser createOS400FTPEntryParser() {
/* 258 */     return createOS400FTPEntryParser(null);
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
/*     */   private FTPFileEntryParser createOS400FTPEntryParser(FTPClientConfig paramFTPClientConfig) {
/* 270 */     if (paramFTPClientConfig != null && "OS/400"
/* 271 */       .equals(paramFTPClientConfig.getServerSystemKey()))
/*     */     {
/* 273 */       return (FTPFileEntryParser)new OS400FTPEntryParser(paramFTPClientConfig);
/*     */     }
/*     */     
/* 276 */     FTPClientConfig fTPClientConfig = (paramFTPClientConfig != null) ? new FTPClientConfig(paramFTPClientConfig) : null;
/* 277 */     return (FTPFileEntryParser)new CompositeFileEntryParser(new FTPFileEntryParser[] { (FTPFileEntryParser)new OS400FTPEntryParser(paramFTPClientConfig), (FTPFileEntryParser)new UnixFTPEntryParser(fTPClientConfig, (fTPClientConfig != null && "UNIX_LTRIM"
/*     */ 
/*     */ 
/*     */             
/* 281 */             .equals(fTPClientConfig.getServerSystemKey()))) });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public FTPFileEntryParser createMVSEntryParser() {
/* 287 */     return (FTPFileEntryParser)new MVSFTPEntryParser();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\ftp\parser\DefaultFTPFileEntryParserFactory.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */