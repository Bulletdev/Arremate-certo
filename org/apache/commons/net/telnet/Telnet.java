/*      */ package org.apache.commons.net.telnet;
/*      */ 
/*      */ import java.io.BufferedInputStream;
/*      */ import java.io.BufferedOutputStream;
/*      */ import java.io.IOException;
/*      */ import java.io.OutputStream;
/*      */ import org.apache.commons.net.SocketClient;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ class Telnet
/*      */   extends SocketClient
/*      */ {
/*      */   static final boolean debug = false;
/*      */   static final boolean debugoptions = false;
/*   34 */   static final byte[] COMMAND_DO = new byte[] { -1, -3 };
/*      */ 
/*      */ 
/*      */   
/*   38 */   static final byte[] COMMAND_DONT = new byte[] { -1, -2 };
/*      */ 
/*      */ 
/*      */   
/*   42 */   static final byte[] COMMAND_WILL = new byte[] { -1, -5 };
/*      */ 
/*      */ 
/*      */   
/*   46 */   static final byte[] COMMAND_WONT = new byte[] { -1, -4 };
/*      */ 
/*      */ 
/*      */   
/*   50 */   static final byte[] COMMAND_SB = new byte[] { -1, -6 };
/*      */ 
/*      */ 
/*      */   
/*   54 */   static final byte[] COMMAND_SE = new byte[] { -1, -16 };
/*      */ 
/*      */   
/*      */   static final int WILL_MASK = 1;
/*      */ 
/*      */   
/*      */   static final int DO_MASK = 2;
/*      */ 
/*      */   
/*      */   static final int REQUESTED_WILL_MASK = 4;
/*      */ 
/*      */   
/*      */   static final int REQUESTED_DO_MASK = 8;
/*      */ 
/*      */   
/*      */   static final int DEFAULT_PORT = 23;
/*      */ 
/*      */   
/*      */   private final int[] doResponse;
/*      */ 
/*      */   
/*      */   private final int[] willResponse;
/*      */ 
/*      */   
/*      */   private final int[] options;
/*      */ 
/*      */   
/*      */   protected static final int TERMINAL_TYPE = 24;
/*      */ 
/*      */   
/*      */   protected static final int TERMINAL_TYPE_SEND = 1;
/*      */ 
/*      */   
/*      */   protected static final int TERMINAL_TYPE_IS = 0;
/*      */   
/*   89 */   static final byte[] COMMAND_IS = new byte[] { 24, 0 };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private String terminalType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final TelnetOptionHandler[] optionHandlers;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  111 */   static final byte[] COMMAND_AYT = new byte[] { -1, -10 };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  118 */   private final Object aytMonitor = new Object();
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private volatile boolean aytFlag = true;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private volatile OutputStream spyStream;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private TelnetNotificationHandler notifhand;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   Telnet() {
/*  140 */     setDefaultPort(23);
/*  141 */     this.doResponse = new int[256];
/*  142 */     this.willResponse = new int[256];
/*  143 */     this.options = new int[256];
/*  144 */     this.optionHandlers = new TelnetOptionHandler[256];
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   Telnet(String paramString) {
/*  156 */     setDefaultPort(23);
/*  157 */     this.doResponse = new int[256];
/*  158 */     this.willResponse = new int[256];
/*  159 */     this.options = new int[256];
/*  160 */     this.terminalType = paramString;
/*  161 */     this.optionHandlers = new TelnetOptionHandler[256];
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   boolean stateIsWill(int paramInt) {
/*  175 */     return ((this.options[paramInt] & 0x1) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   boolean stateIsWont(int paramInt) {
/*  187 */     return !stateIsWill(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   boolean stateIsDo(int paramInt) {
/*  199 */     return ((this.options[paramInt] & 0x2) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   boolean stateIsDont(int paramInt) {
/*  211 */     return !stateIsDo(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   boolean requestedWill(int paramInt) {
/*  223 */     return ((this.options[paramInt] & 0x4) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   boolean requestedWont(int paramInt) {
/*  235 */     return !requestedWill(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   boolean requestedDo(int paramInt) {
/*  247 */     return ((this.options[paramInt] & 0x8) != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   boolean requestedDont(int paramInt) {
/*  259 */     return !requestedDo(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void setWill(int paramInt) throws IOException {
/*  270 */     this.options[paramInt] = this.options[paramInt] | 0x1;
/*      */ 
/*      */     
/*  273 */     if (requestedWill(paramInt))
/*      */     {
/*  275 */       if (this.optionHandlers[paramInt] != null) {
/*      */         
/*  277 */         this.optionHandlers[paramInt].setWill(true);
/*      */ 
/*      */         
/*  280 */         int[] arrayOfInt = this.optionHandlers[paramInt].startSubnegotiationLocal();
/*      */         
/*  282 */         if (arrayOfInt != null)
/*      */         {
/*  284 */           _sendSubnegotiation(arrayOfInt);
/*      */         }
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void setDo(int paramInt) throws IOException {
/*  299 */     this.options[paramInt] = this.options[paramInt] | 0x2;
/*      */ 
/*      */     
/*  302 */     if (requestedDo(paramInt))
/*      */     {
/*  304 */       if (this.optionHandlers[paramInt] != null) {
/*      */         
/*  306 */         this.optionHandlers[paramInt].setDo(true);
/*      */ 
/*      */         
/*  309 */         int[] arrayOfInt = this.optionHandlers[paramInt].startSubnegotiationRemote();
/*      */         
/*  311 */         if (arrayOfInt != null)
/*      */         {
/*  313 */           _sendSubnegotiation(arrayOfInt);
/*      */         }
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void setWantWill(int paramInt) {
/*  327 */     this.options[paramInt] = this.options[paramInt] | 0x4;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void setWantDo(int paramInt) {
/*  337 */     this.options[paramInt] = this.options[paramInt] | 0x8;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void setWont(int paramInt) {
/*  347 */     this.options[paramInt] = this.options[paramInt] & 0xFFFFFFFE;
/*      */ 
/*      */     
/*  350 */     if (this.optionHandlers[paramInt] != null)
/*      */     {
/*  352 */       this.optionHandlers[paramInt].setWill(false);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void setDont(int paramInt) {
/*  364 */     this.options[paramInt] = this.options[paramInt] & 0xFFFFFFFD;
/*      */ 
/*      */     
/*  367 */     if (this.optionHandlers[paramInt] != null)
/*      */     {
/*  369 */       this.optionHandlers[paramInt].setDo(false);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void setWantWont(int paramInt) {
/*  381 */     this.options[paramInt] = this.options[paramInt] & 0xFFFFFFFB;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void setWantDont(int paramInt) {
/*  391 */     this.options[paramInt] = this.options[paramInt] & 0xFFFFFFF7;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void processCommand(int paramInt) {
/*  406 */     if (this.notifhand != null)
/*      */     {
/*  408 */       this.notifhand.receivedNegotiation(5, paramInt);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void processDo(int paramInt) throws IOException {
/*  427 */     if (this.notifhand != null)
/*      */     {
/*  429 */       this.notifhand.receivedNegotiation(1, paramInt);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  434 */     boolean bool = false;
/*      */ 
/*      */ 
/*      */     
/*  438 */     if (this.optionHandlers[paramInt] != null) {
/*      */       
/*  440 */       bool = this.optionHandlers[paramInt].getAcceptLocal();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     }
/*  446 */     else if (paramInt == 24) {
/*      */       
/*  448 */       if (this.terminalType != null && !this.terminalType.isEmpty())
/*      */       {
/*  450 */         bool = true;
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  458 */     if (this.willResponse[paramInt] > 0) {
/*      */       
/*  460 */       this.willResponse[paramInt] = this.willResponse[paramInt] - 1;
/*  461 */       if (this.willResponse[paramInt] > 0 && stateIsWill(paramInt))
/*      */       {
/*  463 */         this.willResponse[paramInt] = this.willResponse[paramInt] - 1;
/*      */       }
/*      */     } 
/*      */     
/*  467 */     if (this.willResponse[paramInt] == 0)
/*      */     {
/*  469 */       if (requestedWont(paramInt)) {
/*      */ 
/*      */         
/*  472 */         switch (paramInt) {
/*      */         
/*      */         } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  481 */         if (bool)
/*      */         {
/*  483 */           setWantWill(paramInt);
/*  484 */           sendWill(paramInt);
/*      */         }
/*      */         else
/*      */         {
/*  488 */           this.willResponse[paramInt] = this.willResponse[paramInt] + 1;
/*  489 */           sendWont(paramInt);
/*      */         
/*      */         }
/*      */       
/*      */       }
/*      */       else {
/*      */         
/*  496 */         switch (paramInt) {
/*      */         
/*      */         } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       } 
/*      */     }
/*  507 */     setWill(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void processDont(int paramInt) throws IOException {
/*  523 */     if (this.notifhand != null)
/*      */     {
/*  525 */       this.notifhand.receivedNegotiation(2, paramInt);
/*      */     }
/*      */ 
/*      */     
/*  529 */     if (this.willResponse[paramInt] > 0) {
/*      */       
/*  531 */       this.willResponse[paramInt] = this.willResponse[paramInt] - 1;
/*  532 */       if (this.willResponse[paramInt] > 0 && stateIsWont(paramInt))
/*      */       {
/*  534 */         this.willResponse[paramInt] = this.willResponse[paramInt] - 1;
/*      */       }
/*      */     } 
/*      */     
/*  538 */     if (this.willResponse[paramInt] == 0 && requestedWill(paramInt)) {
/*      */ 
/*      */       
/*  541 */       switch (paramInt) {
/*      */       
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  550 */       if (stateIsWill(paramInt) || requestedWill(paramInt))
/*      */       {
/*  552 */         sendWont(paramInt);
/*      */       }
/*      */       
/*  555 */       setWantWont(paramInt);
/*      */     } 
/*      */ 
/*      */     
/*  559 */     setWont(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void processWill(int paramInt) throws IOException {
/*  577 */     if (this.notifhand != null)
/*      */     {
/*  579 */       this.notifhand.receivedNegotiation(3, paramInt);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  584 */     boolean bool = false;
/*      */ 
/*      */     
/*  587 */     if (this.optionHandlers[paramInt] != null)
/*      */     {
/*  589 */       bool = this.optionHandlers[paramInt].getAcceptRemote();
/*      */     }
/*      */ 
/*      */     
/*  593 */     if (this.doResponse[paramInt] > 0) {
/*      */       
/*  595 */       this.doResponse[paramInt] = this.doResponse[paramInt] - 1;
/*  596 */       if (this.doResponse[paramInt] > 0 && stateIsDo(paramInt))
/*      */       {
/*  598 */         this.doResponse[paramInt] = this.doResponse[paramInt] - 1;
/*      */       }
/*      */     } 
/*      */     
/*  602 */     if (this.doResponse[paramInt] == 0 && requestedDont(paramInt)) {
/*      */ 
/*      */       
/*  605 */       switch (paramInt) {
/*      */       
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  614 */       if (bool) {
/*      */         
/*  616 */         setWantDo(paramInt);
/*  617 */         sendDo(paramInt);
/*      */       }
/*      */       else {
/*      */         
/*  621 */         this.doResponse[paramInt] = this.doResponse[paramInt] + 1;
/*  622 */         sendDont(paramInt);
/*      */       } 
/*      */     } 
/*      */     
/*  626 */     setDo(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void processWont(int paramInt) throws IOException {
/*  643 */     if (this.notifhand != null)
/*      */     {
/*  645 */       this.notifhand.receivedNegotiation(4, paramInt);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  650 */     if (this.doResponse[paramInt] > 0) {
/*      */       
/*  652 */       this.doResponse[paramInt] = this.doResponse[paramInt] - 1;
/*  653 */       if (this.doResponse[paramInt] > 0 && stateIsDont(paramInt))
/*      */       {
/*  655 */         this.doResponse[paramInt] = this.doResponse[paramInt] - 1;
/*      */       }
/*      */     } 
/*      */     
/*  659 */     if (this.doResponse[paramInt] == 0 && requestedDo(paramInt)) {
/*      */ 
/*      */       
/*  662 */       switch (paramInt) {
/*      */       
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  671 */       if (stateIsDo(paramInt) || requestedDo(paramInt))
/*      */       {
/*  673 */         sendDont(paramInt);
/*      */       }
/*      */       
/*  676 */       setWantDont(paramInt);
/*      */     } 
/*      */ 
/*      */     
/*  680 */     setDont(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void processSuboption(int[] paramArrayOfint, int paramInt) throws IOException {
/*  700 */     if (paramInt > 0)
/*      */     {
/*  702 */       if (this.optionHandlers[paramArrayOfint[0]] != null) {
/*      */ 
/*      */         
/*  705 */         int[] arrayOfInt = this.optionHandlers[paramArrayOfint[0]].answerSubnegotiation(paramArrayOfint, paramInt);
/*      */         
/*  707 */         _sendSubnegotiation(arrayOfInt);
/*      */ 
/*      */       
/*      */       }
/*  711 */       else if (paramInt > 1) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  721 */         if (paramArrayOfint[0] == 24 && paramArrayOfint[1] == 1)
/*      */         {
/*      */           
/*  724 */           sendTerminalType();
/*      */         }
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final synchronized void sendTerminalType() throws IOException {
/*  744 */     if (this.terminalType != null) {
/*      */       
/*  746 */       this._output_.write(COMMAND_SB);
/*  747 */       this._output_.write(COMMAND_IS);
/*  748 */       this._output_.write(this.terminalType.getBytes(getCharset()));
/*  749 */       this._output_.write(COMMAND_SE);
/*  750 */       this._output_.flush();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final synchronized void _sendSubnegotiation(int[] paramArrayOfint) throws IOException {
/*  774 */     if (paramArrayOfint != null) {
/*      */       
/*  776 */       this._output_.write(COMMAND_SB);
/*      */       
/*  778 */       for (int i : paramArrayOfint) {
/*      */         
/*  780 */         byte b = (byte)i;
/*  781 */         if (b == -1) {
/*  782 */           this._output_.write(b);
/*      */         }
/*  784 */         this._output_.write(b);
/*      */       } 
/*  786 */       this._output_.write(COMMAND_SE);
/*      */ 
/*      */       
/*  789 */       this._output_.flush();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final synchronized void _sendCommand(byte paramByte) throws IOException {
/*  804 */     this._output_.write(255);
/*  805 */     this._output_.write(paramByte);
/*  806 */     this._output_.flush();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final synchronized void processAYTResponse() {
/*  815 */     if (!this.aytFlag)
/*      */     {
/*  817 */       synchronized (this.aytMonitor) {
/*      */         
/*  819 */         this.aytFlag = true;
/*  820 */         this.aytMonitor.notifyAll();
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void _connectAction_() throws IOException {
/*      */     byte b;
/*  835 */     for (b = 0; b < 'Ā'; b++) {
/*      */       
/*  837 */       this.doResponse[b] = 0;
/*  838 */       this.willResponse[b] = 0;
/*  839 */       this.options[b] = 0;
/*  840 */       if (this.optionHandlers[b] != null) {
/*      */         
/*  842 */         this.optionHandlers[b].setDo(false);
/*  843 */         this.optionHandlers[b].setWill(false);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  848 */     super._connectAction_();
/*  849 */     this._input_ = new BufferedInputStream(this._input_);
/*  850 */     this._output_ = new BufferedOutputStream(this._output_);
/*      */ 
/*      */     
/*  853 */     for (b = 0; b < 'Ā'; b++) {
/*      */       
/*  855 */       if (this.optionHandlers[b] != null) {
/*      */         
/*  857 */         if (this.optionHandlers[b].getInitLocal())
/*      */         {
/*  859 */           requestWill(this.optionHandlers[b].getOptionCode());
/*      */         }
/*      */         
/*  862 */         if (this.optionHandlers[b].getInitRemote())
/*      */         {
/*  864 */           requestDo(this.optionHandlers[b].getOptionCode());
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final synchronized void sendDo(int paramInt) throws IOException {
/*  884 */     this._output_.write(COMMAND_DO);
/*  885 */     this._output_.write(paramInt);
/*      */ 
/*      */     
/*  888 */     this._output_.flush();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final synchronized void requestDo(int paramInt) throws IOException {
/*  901 */     if ((this.doResponse[paramInt] == 0 && stateIsDo(paramInt)) || 
/*  902 */       requestedDo(paramInt)) {
/*      */       return;
/*      */     }
/*      */     
/*  906 */     setWantDo(paramInt);
/*  907 */     this.doResponse[paramInt] = this.doResponse[paramInt] + 1;
/*  908 */     sendDo(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final synchronized void sendDont(int paramInt) throws IOException {
/*  924 */     this._output_.write(COMMAND_DONT);
/*  925 */     this._output_.write(paramInt);
/*      */ 
/*      */     
/*  928 */     this._output_.flush();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final synchronized void requestDont(int paramInt) throws IOException {
/*  941 */     if ((this.doResponse[paramInt] == 0 && stateIsDont(paramInt)) || 
/*  942 */       requestedDont(paramInt)) {
/*      */       return;
/*      */     }
/*      */     
/*  946 */     setWantDont(paramInt);
/*  947 */     this.doResponse[paramInt] = this.doResponse[paramInt] + 1;
/*  948 */     sendDont(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final synchronized void sendWill(int paramInt) throws IOException {
/*  965 */     this._output_.write(COMMAND_WILL);
/*  966 */     this._output_.write(paramInt);
/*      */ 
/*      */     
/*  969 */     this._output_.flush();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final synchronized void requestWill(int paramInt) throws IOException {
/*  982 */     if ((this.willResponse[paramInt] == 0 && stateIsWill(paramInt)) || 
/*  983 */       requestedWill(paramInt)) {
/*      */       return;
/*      */     }
/*      */     
/*  987 */     setWantWill(paramInt);
/*  988 */     this.doResponse[paramInt] = this.doResponse[paramInt] + 1;
/*  989 */     sendWill(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final synchronized void sendWont(int paramInt) throws IOException {
/* 1005 */     this._output_.write(COMMAND_WONT);
/* 1006 */     this._output_.write(paramInt);
/*      */ 
/*      */     
/* 1009 */     this._output_.flush();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final synchronized void requestWont(int paramInt) throws IOException {
/* 1022 */     if ((this.willResponse[paramInt] == 0 && stateIsWont(paramInt)) || 
/* 1023 */       requestedWont(paramInt)) {
/*      */       return;
/*      */     }
/*      */     
/* 1027 */     setWantWont(paramInt);
/* 1028 */     this.doResponse[paramInt] = this.doResponse[paramInt] + 1;
/* 1029 */     sendWont(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final synchronized void sendByte(int paramInt) throws IOException {
/* 1041 */     this._output_.write(paramInt);
/*      */ 
/*      */     
/* 1044 */     spyWrite(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final boolean _sendAYT(long paramLong) throws IOException, IllegalArgumentException, InterruptedException {
/* 1062 */     boolean bool = false;
/* 1063 */     synchronized (this.aytMonitor) {
/*      */       
/* 1065 */       synchronized (this) {
/*      */         
/* 1067 */         this.aytFlag = false;
/* 1068 */         this._output_.write(COMMAND_AYT);
/* 1069 */         this._output_.flush();
/*      */       } 
/* 1071 */       this.aytMonitor.wait(paramLong);
/* 1072 */       if (!this.aytFlag) {
/*      */         
/* 1074 */         bool = false;
/* 1075 */         this.aytFlag = true;
/*      */       }
/*      */       else {
/*      */         
/* 1079 */         bool = true;
/*      */       } 
/*      */     } 
/*      */     
/* 1083 */     return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void addOptionHandler(TelnetOptionHandler paramTelnetOptionHandler) throws InvalidTelnetOptionException, IOException {
/* 1099 */     int i = paramTelnetOptionHandler.getOptionCode();
/* 1100 */     if (TelnetOption.isValidOption(i)) {
/*      */       
/* 1102 */       if (this.optionHandlers[i] == null) {
/*      */         
/* 1104 */         this.optionHandlers[i] = paramTelnetOptionHandler;
/* 1105 */         if (isConnected())
/*      */         {
/* 1107 */           if (paramTelnetOptionHandler.getInitLocal())
/*      */           {
/* 1109 */             requestWill(i);
/*      */           }
/*      */           
/* 1112 */           if (paramTelnetOptionHandler.getInitRemote())
/*      */           {
/* 1114 */             requestDo(i);
/*      */           }
/*      */         }
/*      */       
/*      */       } else {
/*      */         
/* 1120 */         throw new InvalidTelnetOptionException("Already registered option", i);
/*      */       }
/*      */     
/*      */     }
/*      */     else {
/*      */       
/* 1126 */       throw new InvalidTelnetOptionException("Invalid Option Code", i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void deleteOptionHandler(int paramInt) throws InvalidTelnetOptionException, IOException {
/* 1141 */     if (TelnetOption.isValidOption(paramInt)) {
/*      */       
/* 1143 */       if (this.optionHandlers[paramInt] == null)
/*      */       {
/* 1145 */         throw new InvalidTelnetOptionException("Unregistered option", paramInt);
/*      */       }
/*      */       
/* 1148 */       TelnetOptionHandler telnetOptionHandler = this.optionHandlers[paramInt];
/* 1149 */       this.optionHandlers[paramInt] = null;
/*      */       
/* 1151 */       if (telnetOptionHandler.getWill())
/*      */       {
/* 1153 */         requestWont(paramInt);
/*      */       }
/*      */       
/* 1156 */       if (telnetOptionHandler.getDo())
/*      */       {
/* 1158 */         requestDont(paramInt);
/*      */       }
/*      */     }
/*      */     else {
/*      */       
/* 1163 */       throw new InvalidTelnetOptionException("Invalid Option Code", paramInt);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void _registerSpyStream(OutputStream paramOutputStream) {
/* 1179 */     this.spyStream = paramOutputStream;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void _stopSpyStream() {
/* 1188 */     this.spyStream = null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void spyRead(int paramInt) {
/* 1198 */     OutputStream outputStream = this.spyStream;
/* 1199 */     if (outputStream != null) {
/*      */       
/*      */       try {
/*      */         
/* 1203 */         if (paramInt != 13)
/*      */         {
/* 1205 */           if (paramInt == 10)
/*      */           {
/* 1207 */             outputStream.write(13);
/*      */           }
/* 1209 */           outputStream.write(paramInt);
/* 1210 */           outputStream.flush();
/*      */         }
/*      */       
/* 1213 */       } catch (IOException iOException) {
/*      */         
/* 1215 */         this.spyStream = null;
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void spyWrite(int paramInt) {
/* 1227 */     if (!stateIsDo(1) || 
/* 1228 */       !requestedDo(1)) {
/*      */       
/* 1230 */       OutputStream outputStream = this.spyStream;
/* 1231 */       if (outputStream != null) {
/*      */         
/*      */         try {
/*      */           
/* 1235 */           outputStream.write(paramInt);
/* 1236 */           outputStream.flush();
/*      */         }
/* 1238 */         catch (IOException iOException) {
/*      */           
/* 1240 */           this.spyStream = null;
/*      */         } 
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void registerNotifHandler(TelnetNotificationHandler paramTelnetNotificationHandler) {
/* 1255 */     this.notifhand = paramTelnetNotificationHandler;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void unregisterNotifHandler() {
/* 1264 */     this.notifhand = null;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\telnet\Telnet.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */