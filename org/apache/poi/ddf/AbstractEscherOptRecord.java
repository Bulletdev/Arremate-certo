/*     */ package org.apache.poi.ddf;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.apache.poi.util.HexDump;
/*     */ import org.apache.poi.util.LittleEndian;
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
/*     */ public abstract class AbstractEscherOptRecord
/*     */   extends EscherRecord
/*     */ {
/*  34 */   protected List<EscherProperty> properties = new ArrayList<EscherProperty>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addEscherProperty(EscherProperty paramEscherProperty) {
/*  43 */     this.properties.add(paramEscherProperty);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int fillFields(byte[] paramArrayOfbyte, int paramInt, EscherRecordFactory paramEscherRecordFactory) {
/*  50 */     int i = readHeader(paramArrayOfbyte, paramInt);
/*  51 */     short s = readInstance(paramArrayOfbyte, paramInt);
/*  52 */     int j = paramInt + 8;
/*     */     
/*  54 */     EscherPropertyFactory escherPropertyFactory = new EscherPropertyFactory();
/*  55 */     this.properties = escherPropertyFactory.createProperties(paramArrayOfbyte, j, s);
/*  56 */     return i + 8;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<EscherProperty> getEscherProperties() {
/*  66 */     return this.properties;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EscherProperty getEscherProperty(int paramInt) {
/*  77 */     return this.properties.get(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private int getPropertiesSize() {
/*  83 */     int i = 0;
/*  84 */     for (EscherProperty escherProperty : this.properties)
/*     */     {
/*  86 */       i += escherProperty.getPropertySize();
/*     */     }
/*     */     
/*  89 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRecordSize() {
/*  95 */     return 8 + getPropertiesSize();
/*     */   }
/*     */ 
/*     */   
/*     */   public <T extends EscherProperty> T lookup(int paramInt) {
/* 100 */     for (EscherProperty escherProperty : this.properties) {
/*     */       
/* 102 */       if (escherProperty.getPropertyNumber() == paramInt)
/*     */       {
/*     */         
/* 105 */         return (T)escherProperty;
/*     */       }
/*     */     } 
/*     */     
/* 109 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int serialize(int paramInt, byte[] paramArrayOfbyte, EscherSerializationListener paramEscherSerializationListener) {
/* 116 */     paramEscherSerializationListener.beforeRecordSerialize(paramInt, getRecordId(), this);
/*     */     
/* 118 */     LittleEndian.putShort(paramArrayOfbyte, paramInt, getOptions());
/* 119 */     LittleEndian.putShort(paramArrayOfbyte, paramInt + 2, getRecordId());
/* 120 */     LittleEndian.putInt(paramArrayOfbyte, paramInt + 4, getPropertiesSize());
/* 121 */     int i = paramInt + 8;
/* 122 */     for (EscherProperty escherProperty : this.properties)
/*     */     {
/* 124 */       i += escherProperty.serializeSimplePart(paramArrayOfbyte, i);
/*     */     }
/* 126 */     for (EscherProperty escherProperty : this.properties)
/*     */     {
/* 128 */       i += escherProperty.serializeComplexPart(paramArrayOfbyte, i);
/*     */     }
/* 130 */     paramEscherSerializationListener.afterRecordSerialize(i, getRecordId(), i - paramInt, this);
/* 131 */     return i - paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void sortProperties() {
/* 139 */     Collections.sort(this.properties, new Comparator<EscherProperty>()
/*     */         {
/*     */           
/*     */           public int compare(EscherProperty param1EscherProperty1, EscherProperty param1EscherProperty2)
/*     */           {
/* 144 */             short s1 = param1EscherProperty1.getPropertyNumber();
/* 145 */             short s2 = param1EscherProperty2.getPropertyNumber();
/* 146 */             return (s1 < s2) ? -1 : ((s1 == s2) ? 0 : 1);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEscherProperty(EscherProperty paramEscherProperty) {
/* 158 */     Iterator<EscherProperty> iterator = this.properties.iterator();
/* 159 */     while (iterator.hasNext()) {
/* 160 */       EscherProperty escherProperty = iterator.next();
/* 161 */       if (escherProperty.getId() == paramEscherProperty.getId()) {
/* 162 */         iterator.remove();
/*     */       }
/*     */     } 
/* 165 */     this.properties.add(paramEscherProperty);
/* 166 */     sortProperties();
/*     */   }
/*     */   
/*     */   public void removeEscherProperty(int paramInt) {
/* 170 */     for (Iterator<EscherProperty> iterator = getEscherProperties().iterator(); iterator.hasNext(); ) {
/* 171 */       EscherProperty escherProperty = iterator.next();
/* 172 */       if (escherProperty.getPropertyNumber() == paramInt) {
/* 173 */         iterator.remove();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 184 */     String str = System.getProperty("line.separator");
/*     */     
/* 186 */     StringBuilder stringBuilder = new StringBuilder();
/* 187 */     stringBuilder.append(getClass().getName());
/* 188 */     stringBuilder.append(":");
/* 189 */     stringBuilder.append(str);
/* 190 */     stringBuilder.append("  isContainer: ");
/* 191 */     stringBuilder.append(isContainerRecord());
/* 192 */     stringBuilder.append(str);
/* 193 */     stringBuilder.append("  version: 0x");
/* 194 */     stringBuilder.append(HexDump.toHex(getVersion()));
/* 195 */     stringBuilder.append(str);
/* 196 */     stringBuilder.append("  instance: 0x");
/* 197 */     stringBuilder.append(HexDump.toHex(getInstance()));
/* 198 */     stringBuilder.append(str);
/* 199 */     stringBuilder.append("  recordId: 0x");
/* 200 */     stringBuilder.append(HexDump.toHex(getRecordId()));
/* 201 */     stringBuilder.append(str);
/* 202 */     stringBuilder.append("  numchildren: ");
/* 203 */     stringBuilder.append(getChildRecords().size());
/* 204 */     stringBuilder.append(str);
/* 205 */     stringBuilder.append("  properties:");
/* 206 */     stringBuilder.append(str);
/*     */     
/* 208 */     for (EscherProperty escherProperty : this.properties)
/*     */     {
/* 210 */       stringBuilder.append("    ").append(escherProperty.toString()).append(str);
/*     */     }
/*     */     
/* 213 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toXml(String paramString) {
/* 218 */     StringBuilder stringBuilder = new StringBuilder();
/* 219 */     stringBuilder.append(paramString).append(formatXmlRecordHeader(getClass().getSimpleName(), HexDump.toHex(getRecordId()), HexDump.toHex(getVersion()), HexDump.toHex(getInstance())));
/*     */     
/* 221 */     for (EscherProperty escherProperty : getEscherProperties()) {
/* 222 */       stringBuilder.append(escherProperty.toXml(paramString + "\t"));
/*     */     }
/* 224 */     stringBuilder.append(paramString).append("</").append(getClass().getSimpleName()).append(">\n");
/* 225 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ddf\AbstractEscherOptRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */