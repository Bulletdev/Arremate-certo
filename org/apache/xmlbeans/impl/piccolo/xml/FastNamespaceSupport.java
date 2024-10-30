/*     */ package org.apache.xmlbeans.impl.piccolo.xml;
/*     */ 
/*     */ import org.apache.xmlbeans.impl.piccolo.util.IntStack;
/*     */ import org.apache.xmlbeans.impl.piccolo.util.StringStack;
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
/*     */ public class FastNamespaceSupport
/*     */ {
/*     */   public static final String XMLNS = "http://www.w3.org/XML/1998/namespace";
/*  43 */   private String[] prefixes = new String[20];
/*  44 */   private String[] uris = new String[20];
/*     */   
/*     */   private int prefixPos;
/*     */   
/*     */   private String defaultURI;
/*  49 */   private StringStack defaultURIs = new StringStack(20);
/*     */   
/*     */   private int prefixCount;
/*     */   
/*  53 */   private IntStack contextPrefixCounts = new IntStack(20);
/*     */ 
/*     */   
/*     */   private int defaultURIContexts;
/*     */   
/*  58 */   private IntStack defaultURIContextCounts = new IntStack(20);
/*     */   
/*     */   public FastNamespaceSupport() {
/*  61 */     reset();
/*     */   }
/*     */   
/*     */   public void reset() {
/*  65 */     this.defaultURIs.clear();
/*  66 */     this.contextPrefixCounts.clear();
/*  67 */     this.defaultURIContextCounts.clear();
/*     */     
/*  69 */     this.prefixPos = -1;
/*  70 */     this.defaultURI = "";
/*  71 */     this.prefixCount = 0;
/*  72 */     this.defaultURIContexts = 0;
/*     */   }
/*     */   
/*     */   public void pushContext() {
/*  76 */     this.defaultURIContexts++;
/*     */     
/*  78 */     this.contextPrefixCounts.push(this.prefixCount);
/*  79 */     this.prefixCount = 0;
/*     */   }
/*     */   
/*     */   public void popContext() {
/*  83 */     if (this.defaultURIContexts <= 0) {
/*  84 */       this.defaultURIContexts = this.defaultURIContextCounts.pop();
/*  85 */       this.defaultURI = this.defaultURIs.pop();
/*     */     } else {
/*  87 */       this.defaultURIContexts--;
/*     */     } 
/*  89 */     this.prefixPos -= this.prefixCount;
/*  90 */     this.prefixCount = this.contextPrefixCounts.pop();
/*     */   }
/*     */   
/*     */   public void declarePrefix(String paramString1, String paramString2) {
/*  94 */     if (paramString1.length() == 0) {
/*  95 */       this.defaultURIContexts--;
/*  96 */       this.defaultURIContextCounts.push(this.defaultURIContexts);
/*  97 */       this.defaultURIs.push(this.defaultURI);
/*  98 */       this.defaultURIContexts = 0;
/*  99 */       this.defaultURI = paramString2;
/*     */     } else {
/*     */       int i;
/* 102 */       for (i = 0; i < this.prefixCount; i++) {
/* 103 */         if (paramString1 == this.prefixes[this.prefixPos - i]) {
/* 104 */           this.uris[this.prefixPos - i] = paramString2;
/*     */           
/*     */           return;
/*     */         } 
/*     */       } 
/*     */       
/* 110 */       this.prefixPos++;
/* 111 */       this.prefixCount++;
/*     */ 
/*     */       
/* 114 */       if (this.prefixPos >= this.prefixes.length) {
/* 115 */         i = this.prefixes.length;
/* 116 */         int j = i * 2;
/* 117 */         String[] arrayOfString1 = new String[j];
/* 118 */         String[] arrayOfString2 = new String[j];
/* 119 */         System.arraycopy(this.prefixes, 0, arrayOfString1, 0, i);
/* 120 */         System.arraycopy(this.uris, 0, arrayOfString2, 0, i);
/* 121 */         this.prefixes = arrayOfString1;
/* 122 */         this.uris = arrayOfString2;
/*     */       } 
/*     */       
/* 125 */       this.prefixes[this.prefixPos] = paramString1;
/* 126 */       this.uris[this.prefixPos] = paramString2;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String[] processName(String paramString, String[] paramArrayOfString, boolean paramBoolean) {
/* 133 */     int i = paramString.indexOf(':');
/* 134 */     paramArrayOfString[2] = paramString;
/* 135 */     if (i < 0) {
/* 136 */       paramArrayOfString[1] = paramString;
/*     */       
/* 138 */       if (paramBoolean) {
/* 139 */         paramArrayOfString[0] = "";
/*     */       } else {
/* 141 */         paramArrayOfString[0] = this.defaultURI;
/* 142 */       }  return paramArrayOfString;
/*     */     } 
/* 144 */     String str = paramString.substring(0, i);
/* 145 */     paramArrayOfString[1] = paramString.substring(i + 1);
/* 146 */     paramArrayOfString[0] = getURI(str); if (getURI(str) == "") {
/* 147 */       return null;
/*     */     }
/* 149 */     return paramArrayOfString;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDefaultURI() {
/* 155 */     return this.defaultURI;
/*     */   }
/*     */   
/*     */   public String getURI(String paramString) {
/* 159 */     if (paramString == null || paramString.length() == 0)
/* 160 */       return this.defaultURI; 
/* 161 */     if (paramString == "xml") {
/* 162 */       return "http://www.w3.org/XML/1998/namespace";
/*     */     }
/* 164 */     for (int i = this.prefixPos; i >= 0; i--) {
/* 165 */       if (paramString == this.prefixes[i])
/* 166 */         return this.uris[i]; 
/*     */     } 
/* 168 */     return "";
/*     */   }
/*     */ 
/*     */   
/*     */   public int getContextSize() {
/* 173 */     return this.prefixCount + ((this.defaultURIContexts == 0 && this.defaultURI != "") ? 1 : 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getContextPrefix(int paramInt) {
/* 179 */     if (paramInt == this.prefixCount && this.defaultURIContexts == 0 && this.defaultURI != "")
/*     */     {
/* 181 */       return "";
/*     */     }
/* 183 */     return this.prefixes[this.prefixPos - paramInt];
/*     */   }
/*     */ 
/*     */   
/*     */   public String getContextURI(int paramInt) {
/* 188 */     if (paramInt == this.prefixCount && this.defaultURIContexts == 0 && this.defaultURI != "")
/*     */     {
/* 190 */       return this.defaultURI;
/*     */     }
/* 192 */     return this.uris[this.prefixPos - paramInt];
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\piccolo\xml\FastNamespaceSupport.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */