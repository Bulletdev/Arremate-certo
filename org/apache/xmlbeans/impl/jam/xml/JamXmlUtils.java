/*    */ package org.apache.xmlbeans.impl.jam.xml;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.io.Writer;
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import javax.xml.stream.XMLStreamException;
/*    */ import org.apache.xmlbeans.impl.jam.JClass;
/*    */ import org.apache.xmlbeans.impl.jam.JamService;
/*    */ import org.apache.xmlbeans.impl.jam.JamServiceFactory;
/*    */ import org.apache.xmlbeans.impl.jam.JamServiceParams;
/*    */ import org.apache.xmlbeans.impl.jam.internal.CachedClassBuilder;
/*    */ import org.apache.xmlbeans.impl.jam.internal.JamServiceImpl;
/*    */ import org.apache.xmlbeans.impl.jam.internal.elements.ElementContext;
/*    */ import org.apache.xmlbeans.impl.jam.provider.JamClassBuilder;
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
/*    */ 
/*    */ 
/*    */ public class JamXmlUtils
/*    */ {
/*    */   public static final JamXmlUtils getInstance() {
/* 40 */     return INSTANCE;
/*    */   }
/* 42 */   private static final JamXmlUtils INSTANCE = new JamXmlUtils();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public JamService createService(InputStream paramInputStream) throws IOException, XMLStreamException {
/* 52 */     if (paramInputStream == null) throw new IllegalArgumentException("null stream"); 
/* 53 */     JamServiceFactory jamServiceFactory = JamServiceFactory.getInstance();
/* 54 */     JamServiceParams jamServiceParams = jamServiceFactory.createServiceParams();
/* 55 */     CachedClassBuilder cachedClassBuilder = new CachedClassBuilder();
/*    */     
/* 57 */     jamServiceParams.addClassBuilder((JamClassBuilder)cachedClassBuilder);
/* 58 */     JamService jamService = jamServiceFactory.createService(jamServiceParams);
/*    */ 
/*    */     
/* 61 */     JamXmlReader jamXmlReader = new JamXmlReader(cachedClassBuilder, paramInputStream, (ElementContext)jamServiceParams);
/* 62 */     jamXmlReader.read();
/*    */ 
/*    */     
/* 65 */     List list = Arrays.asList(cachedClassBuilder.getClassNames());
/* 66 */     list.addAll(Arrays.asList(jamService.getClassNames()));
/* 67 */     String[] arrayOfString = new String[list.size()];
/* 68 */     list.toArray(arrayOfString);
/* 69 */     ((JamServiceImpl)jamService).setClassNames(arrayOfString);
/*    */     
/* 71 */     return jamService;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void toXml(JClass[] paramArrayOfJClass, Writer paramWriter) throws IOException, XMLStreamException {
/* 77 */     if (paramArrayOfJClass == null) throw new IllegalArgumentException("null classes"); 
/* 78 */     if (paramWriter == null) throw new IllegalArgumentException("null writer"); 
/* 79 */     JamXmlWriter jamXmlWriter = new JamXmlWriter(paramWriter);
/* 80 */     jamXmlWriter.begin();
/* 81 */     for (byte b = 0; b < paramArrayOfJClass.length; ) { jamXmlWriter.write(paramArrayOfJClass[b]); b++; }
/* 82 */      jamXmlWriter.end();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\xml\JamXmlUtils.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */