/*     */ package ch.qos.logback.core.joran.action;
/*     */ 
/*     */ import ch.qos.logback.core.joran.spi.InterpretationContext;
/*     */ import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
/*     */ import ch.qos.logback.core.util.Loader;
/*     */ import ch.qos.logback.core.util.OptionHelper;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.net.URL;
/*     */ import java.util.Properties;
/*     */ import org.xml.sax.Attributes;
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
/*     */ public class PropertyAction
/*     */   extends Action
/*     */ {
/*     */   static final String RESOURCE_ATTRIBUTE = "resource";
/*  45 */   static String INVALID_ATTRIBUTES = "In <property> element, either the \"file\" attribute alone, or the \"resource\" element alone, or both the \"name\" and \"value\" attributes must be set.";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void begin(InterpretationContext paramInterpretationContext, String paramString, Attributes paramAttributes) {
/*  55 */     if ("substitutionProperty".equals(paramString)) {
/*  56 */       addWarn("[substitutionProperty] element has been deprecated. Please use the [property] element instead.");
/*     */     }
/*     */     
/*  59 */     String str1 = paramAttributes.getValue("name");
/*  60 */     String str2 = paramAttributes.getValue("value");
/*  61 */     String str3 = paramAttributes.getValue("scope");
/*     */     
/*  63 */     ActionUtil.Scope scope = ActionUtil.stringToScope(str3);
/*     */     
/*  65 */     if (checkFileAttributeSanity(paramAttributes)) {
/*  66 */       String str = paramAttributes.getValue("file");
/*  67 */       str = paramInterpretationContext.subst(str);
/*     */       try {
/*  69 */         FileInputStream fileInputStream = new FileInputStream(str);
/*  70 */         loadAndSetProperties(paramInterpretationContext, fileInputStream, scope);
/*  71 */       } catch (FileNotFoundException fileNotFoundException) {
/*  72 */         addError("Could not find properties file [" + str + "].");
/*  73 */       } catch (IOException iOException) {
/*  74 */         addError("Could not read properties file [" + str + "].", iOException);
/*     */       } 
/*  76 */     } else if (checkResourceAttributeSanity(paramAttributes)) {
/*  77 */       String str = paramAttributes.getValue("resource");
/*  78 */       str = paramInterpretationContext.subst(str);
/*  79 */       URL uRL = Loader.getResourceBySelfClassLoader(str);
/*  80 */       if (uRL == null) {
/*  81 */         addError("Could not find resource [" + str + "].");
/*     */       } else {
/*     */         try {
/*  84 */           InputStream inputStream = uRL.openStream();
/*  85 */           loadAndSetProperties(paramInterpretationContext, inputStream, scope);
/*  86 */         } catch (IOException iOException) {
/*  87 */           addError("Could not read resource file [" + str + "].", iOException);
/*     */         } 
/*     */       } 
/*  90 */     } else if (checkValueNameAttributesSanity(paramAttributes)) {
/*  91 */       str2 = RegularEscapeUtil.basicEscape(str2);
/*     */       
/*  93 */       str2 = str2.trim();
/*  94 */       str2 = paramInterpretationContext.subst(str2);
/*  95 */       ActionUtil.setProperty(paramInterpretationContext, str1, str2, scope);
/*     */     } else {
/*     */       
/*  98 */       addError(INVALID_ATTRIBUTES);
/*     */     } 
/*     */   }
/*     */   
/*     */   void loadAndSetProperties(InterpretationContext paramInterpretationContext, InputStream paramInputStream, ActionUtil.Scope paramScope) throws IOException {
/* 103 */     Properties properties = new Properties();
/* 104 */     properties.load(paramInputStream);
/* 105 */     paramInputStream.close();
/* 106 */     ActionUtil.setProperties(paramInterpretationContext, properties, paramScope);
/*     */   }
/*     */   
/*     */   boolean checkFileAttributeSanity(Attributes paramAttributes) {
/* 110 */     String str1 = paramAttributes.getValue("file");
/* 111 */     String str2 = paramAttributes.getValue("name");
/* 112 */     String str3 = paramAttributes.getValue("value");
/* 113 */     String str4 = paramAttributes.getValue("resource");
/*     */     
/* 115 */     return (!OptionHelper.isEmpty(str1) && OptionHelper.isEmpty(str2) && OptionHelper.isEmpty(str3) && OptionHelper.isEmpty(str4));
/*     */   }
/*     */   
/*     */   boolean checkResourceAttributeSanity(Attributes paramAttributes) {
/* 119 */     String str1 = paramAttributes.getValue("file");
/* 120 */     String str2 = paramAttributes.getValue("name");
/* 121 */     String str3 = paramAttributes.getValue("value");
/* 122 */     String str4 = paramAttributes.getValue("resource");
/*     */     
/* 124 */     return (!OptionHelper.isEmpty(str4) && OptionHelper.isEmpty(str2) && OptionHelper.isEmpty(str3) && OptionHelper.isEmpty(str1));
/*     */   }
/*     */   
/*     */   boolean checkValueNameAttributesSanity(Attributes paramAttributes) {
/* 128 */     String str1 = paramAttributes.getValue("file");
/* 129 */     String str2 = paramAttributes.getValue("name");
/* 130 */     String str3 = paramAttributes.getValue("value");
/* 131 */     String str4 = paramAttributes.getValue("resource");
/*     */     
/* 133 */     return (!OptionHelper.isEmpty(str2) && !OptionHelper.isEmpty(str3) && OptionHelper.isEmpty(str1) && OptionHelper.isEmpty(str4));
/*     */   }
/*     */   
/*     */   public void end(InterpretationContext paramInterpretationContext, String paramString) {}
/*     */   
/*     */   public void finish(InterpretationContext paramInterpretationContext) {}
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\joran\action\PropertyAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */