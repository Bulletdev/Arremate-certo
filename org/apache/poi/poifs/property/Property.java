/*     */ package org.apache.poi.poifs.property;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import org.apache.poi.hpsf.ClassID;
/*     */ import org.apache.poi.poifs.dev.POIFSViewable;
/*     */ import org.apache.poi.util.ByteField;
/*     */ import org.apache.poi.util.IntegerField;
/*     */ import org.apache.poi.util.ShortField;
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
/*     */ public abstract class Property
/*     */   implements POIFSViewable, Child
/*     */ {
/*     */   private static final byte _default_fill = 0;
/*     */   private static final int _name_size_offset = 64;
/*     */   private static final int _max_name_length = 31;
/*     */   protected static final int _NO_INDEX = -1;
/*     */   private static final int _node_color_offset = 67;
/*     */   private static final int _previous_property_offset = 68;
/*     */   private static final int _next_property_offset = 72;
/*     */   private static final int _child_property_offset = 76;
/*     */   private static final int _storage_clsid_offset = 80;
/*     */   private static final int _user_flags_offset = 96;
/*     */   private static final int _seconds_1_offset = 100;
/*     */   private static final int _days_1_offset = 104;
/*     */   private static final int _seconds_2_offset = 108;
/*     */   private static final int _days_2_offset = 112;
/*     */   private static final int _start_block_offset = 116;
/*     */   private static final int _size_offset = 120;
/*     */   protected static final byte _NODE_BLACK = 1;
/*     */   protected static final byte _NODE_RED = 0;
/*     */   private static final int _big_block_minimum_bytes = 4096;
/*     */   private String _name;
/*     */   private ShortField _name_size;
/*     */   private ByteField _property_type;
/*     */   private ByteField _node_color;
/*     */   private IntegerField _previous_property;
/*     */   private IntegerField _next_property;
/*     */   private IntegerField _child_property;
/*     */   private ClassID _storage_clsid;
/*     */   private IntegerField _user_flags;
/*     */   private IntegerField _seconds_1;
/*     */   private IntegerField _days_1;
/*     */   private IntegerField _seconds_2;
/*     */   private IntegerField _days_2;
/*     */   private IntegerField _start_block;
/*     */   private IntegerField _size;
/*     */   private byte[] _raw_data;
/*     */   private int _index;
/*     */   private Child _next_child;
/*     */   private Child _previous_child;
/*     */   
/*     */   protected Property() {
/*  92 */     this._raw_data = new byte[128];
/*  93 */     Arrays.fill(this._raw_data, (byte)0);
/*  94 */     this._name_size = new ShortField(64);
/*  95 */     this._property_type = new ByteField(66);
/*     */     
/*  97 */     this._node_color = new ByteField(67);
/*  98 */     this._previous_property = new IntegerField(68, -1, this._raw_data);
/*     */     
/* 100 */     this._next_property = new IntegerField(72, -1, this._raw_data);
/*     */     
/* 102 */     this._child_property = new IntegerField(76, -1, this._raw_data);
/*     */     
/* 104 */     this._storage_clsid = new ClassID(this._raw_data, 80);
/* 105 */     this._user_flags = new IntegerField(96, 0, this._raw_data);
/* 106 */     this._seconds_1 = new IntegerField(100, 0, this._raw_data);
/*     */     
/* 108 */     this._days_1 = new IntegerField(104, 0, this._raw_data);
/* 109 */     this._seconds_2 = new IntegerField(108, 0, this._raw_data);
/*     */     
/* 111 */     this._days_2 = new IntegerField(112, 0, this._raw_data);
/* 112 */     this._start_block = new IntegerField(116);
/* 113 */     this._size = new IntegerField(120, 0, this._raw_data);
/* 114 */     this._index = -1;
/* 115 */     setName("");
/* 116 */     setNextChild(null);
/* 117 */     setPreviousChild(null);
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
/*     */   protected Property(int paramInt1, byte[] paramArrayOfbyte, int paramInt2) {
/* 129 */     this._raw_data = new byte[128];
/* 130 */     System.arraycopy(paramArrayOfbyte, paramInt2, this._raw_data, 0, 128);
/*     */     
/* 132 */     this._name_size = new ShortField(64, this._raw_data);
/* 133 */     this._property_type = new ByteField(66, this._raw_data);
/*     */     
/* 135 */     this._node_color = new ByteField(67, this._raw_data);
/* 136 */     this._previous_property = new IntegerField(68, this._raw_data);
/*     */     
/* 138 */     this._next_property = new IntegerField(72, this._raw_data);
/*     */     
/* 140 */     this._child_property = new IntegerField(76, this._raw_data);
/*     */     
/* 142 */     this._storage_clsid = new ClassID(this._raw_data, 80);
/* 143 */     this._user_flags = new IntegerField(96, 0, this._raw_data);
/* 144 */     this._seconds_1 = new IntegerField(100, this._raw_data);
/* 145 */     this._days_1 = new IntegerField(104, this._raw_data);
/* 146 */     this._seconds_2 = new IntegerField(108, this._raw_data);
/* 147 */     this._days_2 = new IntegerField(112, this._raw_data);
/* 148 */     this._start_block = new IntegerField(116, this._raw_data);
/* 149 */     this._size = new IntegerField(120, this._raw_data);
/* 150 */     this._index = paramInt1;
/* 151 */     int i = this._name_size.get() / 2 - 1;
/*     */ 
/*     */     
/* 154 */     if (i < 1) {
/*     */       
/* 156 */       this._name = "";
/*     */     }
/*     */     else {
/*     */       
/* 160 */       char[] arrayOfChar = new char[i];
/* 161 */       boolean bool = false;
/*     */       
/* 163 */       for (byte b = 0; b < i; b++) {
/*     */         
/* 165 */         arrayOfChar[b] = (char)(new ShortField(bool, this._raw_data)).get();
/*     */         
/* 167 */         bool += true;
/*     */       } 
/* 169 */       this._name = new String(arrayOfChar, 0, i);
/*     */     } 
/* 171 */     this._next_child = null;
/* 172 */     this._previous_child = null;
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
/*     */   public void writeData(OutputStream paramOutputStream) throws IOException {
/* 187 */     paramOutputStream.write(this._raw_data);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStartBlock(int paramInt) {
/* 198 */     this._start_block.set(paramInt, this._raw_data);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getStartBlock() {
/* 206 */     return this._start_block.get();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSize() {
/* 216 */     return this._size.get();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean shouldUseSmallBlocks() {
/* 227 */     return isSmall(this._size.get());
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
/*     */   public static boolean isSmall(int paramInt) {
/* 240 */     return (paramInt < 4096);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 250 */     return this._name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract boolean isDirectory();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ClassID getStorageClsid() {
/* 265 */     return this._storage_clsid;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setName(String paramString) {
/* 275 */     char[] arrayOfChar = paramString.toCharArray();
/* 276 */     int i = Math.min(arrayOfChar.length, 31);
/*     */     
/* 278 */     this._name = new String(arrayOfChar, 0, i);
/* 279 */     short s = 0;
/* 280 */     byte b = 0;
/*     */     
/* 282 */     for (; b < i; b++) {
/*     */       
/* 284 */       new ShortField(s, (short)arrayOfChar[b], this._raw_data);
/* 285 */       s = (short)(s + 2);
/*     */     } 
/* 287 */     for (; b < 32; b++) {
/*     */       
/* 289 */       new ShortField(s, (short)0, this._raw_data);
/* 290 */       s = (short)(s + 2);
/*     */     } 
/*     */ 
/*     */     
/* 294 */     this._name_size.set((short)((i + 1) * 2), this._raw_data);
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
/*     */   public void setStorageClsid(ClassID paramClassID) {
/* 306 */     this._storage_clsid = paramClassID;
/* 307 */     if (paramClassID == null) {
/* 308 */       Arrays.fill(this._raw_data, 80, 96, (byte)0);
/*     */     } else {
/* 310 */       paramClassID.write(this._raw_data, 80);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setPropertyType(byte paramByte) {
/* 320 */     this._property_type.set(paramByte, this._raw_data);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setNodeColor(byte paramByte) {
/* 330 */     this._node_color.set(paramByte, this._raw_data);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setChildProperty(int paramInt) {
/* 340 */     this._child_property.set(paramInt, this._raw_data);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int getChildIndex() {
/* 350 */     return this._child_property.get();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setSize(int paramInt) {
/* 360 */     this._size.set(paramInt, this._raw_data);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setIndex(int paramInt) {
/* 371 */     this._index = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int getIndex() {
/* 381 */     return this._index;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void preWrite();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int getNextChildIndex() {
/* 397 */     return this._next_property.get();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int getPreviousChildIndex() {
/* 407 */     return this._previous_property.get();
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
/*     */   static boolean isValidIndex(int paramInt) {
/* 419 */     return (paramInt != -1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Child getNextChild() {
/* 429 */     return this._next_child;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Child getPreviousChild() {
/* 439 */     return this._previous_child;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNextChild(Child paramChild) {
/* 450 */     this._next_child = paramChild;
/* 451 */     this._next_property.set((paramChild == null) ? -1 : ((Property)paramChild).getIndex(), this._raw_data);
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
/*     */   public void setPreviousChild(Child paramChild) {
/* 464 */     this._previous_child = paramChild;
/* 465 */     this._previous_property.set((paramChild == null) ? -1 : ((Property)paramChild).getIndex(), this._raw_data);
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
/*     */   public Object[] getViewableArray() {
/* 478 */     Object[] arrayOfObject = new Object[5];
/*     */     
/* 480 */     arrayOfObject[0] = "Name          = \"" + getName() + "\"";
/* 481 */     arrayOfObject[1] = "Property Type = " + this._property_type.get();
/* 482 */     arrayOfObject[2] = "Node Color    = " + this._node_color.get();
/* 483 */     long l = this._days_1.get();
/*     */     
/* 485 */     l <<= 32L;
/* 486 */     l += this._seconds_1.get() & 0xFFFFL;
/* 487 */     arrayOfObject[3] = "Time 1        = " + l;
/* 488 */     l = this._days_2.get();
/* 489 */     l <<= 32L;
/* 490 */     l += this._seconds_2.get() & 0xFFFFL;
/* 491 */     arrayOfObject[4] = "Time 2        = " + l;
/* 492 */     return arrayOfObject;
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
/*     */   public Iterator<Object> getViewableIterator() {
/* 504 */     return Collections.<Object>emptyList().iterator();
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
/*     */   public boolean preferArray() {
/* 516 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getShortDescription() {
/* 527 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/* 529 */     stringBuffer.append("Property: \"").append(getName()).append("\"");
/* 530 */     return stringBuffer.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\property\Property.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */