/*     */ package org.apache.poi.poifs.dev;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.LineNumberReader;
/*     */ import java.io.StringReader;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
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
/*     */ public class POIFSViewEngine
/*     */ {
/*  37 */   private static final String _EOL = System.getProperty("line.separator");
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
/*     */   public static List<String> inspectViewable(Object paramObject, boolean paramBoolean, int paramInt, String paramString) {
/*  58 */     ArrayList<String> arrayList = new ArrayList();
/*     */     
/*  60 */     if (paramObject instanceof POIFSViewable) {
/*     */       
/*  62 */       POIFSViewable pOIFSViewable = (POIFSViewable)paramObject;
/*     */       
/*  64 */       arrayList.add(indent(paramInt, paramString, pOIFSViewable.getShortDescription()));
/*     */       
/*  66 */       if (paramBoolean)
/*     */       {
/*  68 */         if (pOIFSViewable.preferArray())
/*     */         {
/*  70 */           Object[] arrayOfObject = pOIFSViewable.getViewableArray();
/*     */           
/*  72 */           for (byte b = 0; b < arrayOfObject.length; b++)
/*     */           {
/*  74 */             arrayList.addAll(inspectViewable(arrayOfObject[b], paramBoolean, paramInt + 1, paramString));
/*     */           
/*     */           }
/*     */         
/*     */         }
/*     */         else
/*     */         {
/*  81 */           Iterator<Object> iterator = pOIFSViewable.getViewableIterator();
/*     */           
/*  83 */           while (iterator.hasNext())
/*     */           {
/*  85 */             arrayList.addAll(inspectViewable(iterator.next(), paramBoolean, paramInt + 1, paramString));
/*     */           
/*     */           }
/*     */         
/*     */         }
/*     */       
/*     */       }
/*     */     }
/*     */     else {
/*     */       
/*  95 */       arrayList.add(indent(paramInt, paramString, paramObject.toString()));
/*     */     } 
/*     */     
/*  98 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static String indent(int paramInt, String paramString1, String paramString2) {
/* 104 */     StringBuffer stringBuffer1 = new StringBuffer();
/* 105 */     StringBuffer stringBuffer2 = new StringBuffer();
/*     */     
/* 107 */     for (byte b = 0; b < paramInt; b++)
/*     */     {
/* 109 */       stringBuffer2.append(paramString1);
/*     */     }
/* 111 */     LineNumberReader lineNumberReader = new LineNumberReader(new StringReader(paramString2));
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 116 */       String str = lineNumberReader.readLine();
/*     */       
/* 118 */       while (str != null)
/*     */       {
/* 120 */         stringBuffer1.append(stringBuffer2).append(str).append(_EOL);
/* 121 */         str = lineNumberReader.readLine();
/*     */       }
/*     */     
/* 124 */     } catch (IOException iOException) {
/*     */       
/* 126 */       stringBuffer1.append(stringBuffer2).append(iOException.getMessage()).append(_EOL);
/*     */     } 
/*     */     
/* 129 */     return stringBuffer1.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\dev\POIFSViewEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */