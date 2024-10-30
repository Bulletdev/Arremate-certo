/*     */ package com.sun.jna.platform.win32;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public enum Win32VK
/*     */ {
/*  31 */   VK_UNDEFINED(0),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  36 */   VK_LBUTTON(1),
/*  37 */   VK_RBUTTON(2),
/*  38 */   VK_CANCEL(3),
/*  39 */   VK_MBUTTON(4),
/*     */   
/*  41 */   VK_XBUTTON1(5, 1280),
/*  42 */   VK_XBUTTON2(6, 1280),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  47 */   VK_RESERVED_07(7),
/*     */   
/*  49 */   VK_BACK(8),
/*  50 */   VK_TAB(9),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  55 */   VK_RESERVED_0A(10),
/*  56 */   VK_RESERVED_0B(11),
/*     */   
/*  58 */   VK_CLEAR(12),
/*  59 */   VK_RETURN(13),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  64 */   VK_UNASSIGNED_0E(14),
/*  65 */   VK_UNASSIGNED_0F(15),
/*     */   
/*  67 */   VK_SHIFT(16),
/*  68 */   VK_CONTROL(17),
/*  69 */   VK_MENU(18),
/*  70 */   VK_PAUSE(19),
/*  71 */   VK_CAPITAL(20),
/*     */   
/*  73 */   VK_KANA(21),
/*  74 */   VK_HANGEUL(21),
/*  75 */   VK_HANGUL(21),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  80 */   VK_UNASSIGNED_16(22),
/*     */   
/*  82 */   VK_JUNJA(23),
/*  83 */   VK_FINAL(24),
/*  84 */   VK_HANJA(25),
/*  85 */   VK_KANJI(25),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  90 */   VK_UNASSIGNED_1A(26),
/*     */   
/*  92 */   VK_ESCAPE(27),
/*     */   
/*  94 */   VK_CONVERT(28),
/*  95 */   VK_NONCONVERT(29),
/*  96 */   VK_ACCEPT(30),
/*  97 */   VK_MODECHANGE(31),
/*     */   
/*  99 */   VK_SPACE(32),
/* 100 */   VK_PRIOR(33),
/* 101 */   VK_NEXT(34),
/* 102 */   VK_END(35),
/* 103 */   VK_HOME(36),
/* 104 */   VK_LEFT(37),
/* 105 */   VK_UP(38),
/* 106 */   VK_RIGHT(39),
/* 107 */   VK_DOWN(40),
/* 108 */   VK_SELECT(41),
/* 109 */   VK_PRINT(42),
/* 110 */   VK_EXECUTE(43),
/* 111 */   VK_SNAPSHOT(44),
/* 112 */   VK_INSERT(45),
/* 113 */   VK_DELETE(46),
/* 114 */   VK_HELP(47),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 119 */   VK_0(48),
/* 120 */   VK_1(49),
/* 121 */   VK_2(50),
/* 122 */   VK_3(51),
/* 123 */   VK_4(52),
/* 124 */   VK_5(53),
/* 125 */   VK_6(54),
/* 126 */   VK_7(55),
/* 127 */   VK_8(56),
/* 128 */   VK_9(57),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 133 */   VK_UNASSIGNED_3A(58),
/* 134 */   VK_UNASSIGNED_3B(59),
/* 135 */   VK_UNASSIGNED_3C(60),
/* 136 */   VK_UNASSIGNED_3D(61),
/* 137 */   VK_UNASSIGNED_3E(62),
/* 138 */   VK_UNASSIGNED_3F(63),
/* 139 */   VK_UNASSIGNED_40(64),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 144 */   VK_A(65),
/* 145 */   VK_B(66),
/* 146 */   VK_C(67),
/* 147 */   VK_D(68),
/* 148 */   VK_E(69),
/* 149 */   VK_F(70),
/* 150 */   VK_G(71),
/* 151 */   VK_H(72),
/* 152 */   VK_I(73),
/* 153 */   VK_J(74),
/* 154 */   VK_K(75),
/* 155 */   VK_L(76),
/* 156 */   VK_M(77),
/* 157 */   VK_N(78),
/* 158 */   VK_O(79),
/* 159 */   VK_P(80),
/* 160 */   VK_Q(81),
/* 161 */   VK_R(82),
/* 162 */   VK_S(83),
/* 163 */   VK_T(84),
/* 164 */   VK_U(85),
/* 165 */   VK_V(86),
/* 166 */   VK_W(87),
/* 167 */   VK_X(88),
/* 168 */   VK_Y(89),
/* 169 */   VK_Z(90),
/*     */ 
/*     */   
/* 172 */   VK_LWIN(91),
/*     */   
/* 174 */   VK_RWIN(92),
/*     */   
/* 176 */   VK_APPS(93),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 181 */   VK_RESERVED_5E(94),
/* 182 */   VK_SLEEP(95),
/*     */   
/* 184 */   VK_NUMPAD0(96),
/* 185 */   VK_NUMPAD1(97),
/* 186 */   VK_NUMPAD2(98),
/* 187 */   VK_NUMPAD3(99),
/* 188 */   VK_NUMPAD4(100),
/* 189 */   VK_NUMPAD5(101),
/* 190 */   VK_NUMPAD6(102),
/* 191 */   VK_NUMPAD7(103),
/* 192 */   VK_NUMPAD8(104),
/* 193 */   VK_NUMPAD9(105),
/* 194 */   VK_MULTIPLY(106),
/* 195 */   VK_ADD(107),
/* 196 */   VK_SEPARATOR(108),
/* 197 */   VK_SUBTRACT(109),
/* 198 */   VK_DECIMAL(110),
/* 199 */   VK_DIVIDE(111),
/* 200 */   VK_F1(112),
/* 201 */   VK_F2(113),
/* 202 */   VK_F3(114),
/* 203 */   VK_F4(115),
/* 204 */   VK_F5(116),
/* 205 */   VK_F6(117),
/* 206 */   VK_F7(118),
/* 207 */   VK_F8(119),
/* 208 */   VK_F9(120),
/* 209 */   VK_F10(121),
/* 210 */   VK_F11(122),
/* 211 */   VK_F12(123),
/* 212 */   VK_F13(124),
/* 213 */   VK_F14(125),
/* 214 */   VK_F15(126),
/* 215 */   VK_F16(127),
/* 216 */   VK_F17(128),
/* 217 */   VK_F18(129),
/* 218 */   VK_F19(130),
/* 219 */   VK_F20(131),
/* 220 */   VK_F21(132),
/* 221 */   VK_F22(133),
/* 222 */   VK_F23(134),
/* 223 */   VK_F24(135),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 229 */   VK_NAVIGATION_VIEW(136, 1540),
/* 230 */   VK_NAVIGATION_MENU(137, 1540),
/* 231 */   VK_NAVIGATION_UP(138, 1540),
/* 232 */   VK_NAVIGATION_DOWN(139, 1540),
/* 233 */   VK_NAVIGATION_LEFT(140, 1540),
/* 234 */   VK_NAVIGATION_RIGHT(141, 1540),
/* 235 */   VK_NAVIGATION_ACCEPT(142, 1540),
/* 236 */   VK_NAVIGATION_CANCEL(143, 1540),
/*     */   
/* 238 */   VK_NUMLOCK(144),
/* 239 */   VK_SCROLL(145),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 244 */   VK_OEM_NEC_EQUAL(146),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 249 */   VK_OEM_FJ_JISHO(146),
/* 250 */   VK_OEM_FJ_MASSHOU(147),
/* 251 */   VK_OEM_FJ_TOUROKU(148),
/* 252 */   VK_OEM_FJ_LOYA(149),
/* 253 */   VK_OEM_FJ_ROYA(150),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 258 */   VK_UNASSIGNED_97(151),
/* 259 */   VK_UNASSIGNED_98(152),
/* 260 */   VK_UNASSIGNED_99(153),
/* 261 */   VK_UNASSIGNED_9A(154),
/* 262 */   VK_UNASSIGNED_9B(155),
/* 263 */   VK_UNASSIGNED_9C(156),
/* 264 */   VK_UNASSIGNED_9D(157),
/* 265 */   VK_UNASSIGNED_9E(158),
/* 266 */   VK_UNASSIGNED_9F(159),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 273 */   VK_LSHIFT(160),
/* 274 */   VK_RSHIFT(161),
/* 275 */   VK_LCONTROL(162),
/* 276 */   VK_RCONTROL(163),
/* 277 */   VK_LMENU(164),
/* 278 */   VK_RMENU(165),
/*     */   
/* 280 */   VK_BROWSER_BACK(166, 1280),
/* 281 */   VK_BROWSER_FORWARD(167, 1280),
/* 282 */   VK_BROWSER_REFRESH(168, 1280),
/* 283 */   VK_BROWSER_STOP(169, 1280),
/* 284 */   VK_BROWSER_SEARCH(170, 1280),
/* 285 */   VK_BROWSER_FAVORITES(171, 1280),
/* 286 */   VK_BROWSER_HOME(172, 1280),
/*     */   
/* 288 */   VK_VOLUME_MUTE(173, 1280),
/* 289 */   VK_VOLUME_DOWN(174, 1280),
/* 290 */   VK_VOLUME_UP(175, 1280),
/* 291 */   VK_MEDIA_NEXT_TRACK(176, 1280),
/* 292 */   VK_MEDIA_PREV_TRACK(177, 1280),
/* 293 */   VK_MEDIA_STOP(178, 1280),
/* 294 */   VK_MEDIA_PLAY_PAUSE(179, 1280),
/* 295 */   VK_LAUNCH_MAIL(180, 1280),
/* 296 */   VK_LAUNCH_MEDIA_SELECT(181, 1280),
/* 297 */   VK_LAUNCH_APP1(182, 1280),
/* 298 */   VK_LAUNCH_APP2(183, 1280),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 303 */   VK_RESERVED_B8(184),
/* 304 */   VK_RESERVED_B9(185),
/*     */   
/* 306 */   VK_OEM_1(186),
/* 307 */   VK_OEM_PLUS(187),
/* 308 */   VK_OEM_COMMA(188),
/* 309 */   VK_OEM_MINUS(189),
/* 310 */   VK_OEM_PERIOD(190),
/* 311 */   VK_OEM_2(191),
/* 312 */   VK_OEM_3(192),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 317 */   VK_RESERVED_C1(193),
/* 318 */   VK_RESERVED_C2(194),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 324 */   VK_GAMEPAD_A(195, 1540),
/* 325 */   VK_GAMEPAD_B(196, 1540),
/* 326 */   VK_GAMEPAD_X(197, 1540),
/* 327 */   VK_GAMEPAD_Y(198, 1540),
/* 328 */   VK_GAMEPAD_RIGHT_SHOULDER(199, 1540),
/* 329 */   VK_GAMEPAD_LEFT_SHOULDER(200, 1540),
/* 330 */   VK_GAMEPAD_LEFT_TRIGGER(201, 1540),
/* 331 */   VK_GAMEPAD_RIGHT_TRIGGER(202, 1540),
/* 332 */   VK_GAMEPAD_DPAD_UP(203, 1540),
/* 333 */   VK_GAMEPAD_DPAD_DOWN(204, 1540),
/* 334 */   VK_GAMEPAD_DPAD_LEFT(205, 1540),
/* 335 */   VK_GAMEPAD_DPAD_RIGHT(206, 1540),
/* 336 */   VK_GAMEPAD_MENU(207, 1540),
/* 337 */   VK_GAMEPAD_VIEW(208, 1540),
/* 338 */   VK_GAMEPAD_LEFT_THUMBSTICK_BUTTON(209, 1540),
/* 339 */   VK_GAMEPAD_RIGHT_THUMBSTICK_BUTTON(210, 1540),
/* 340 */   VK_GAMEPAD_LEFT_THUMBSTICK_UP(211, 1540),
/* 341 */   VK_GAMEPAD_LEFT_THUMBSTICK_DOWN(212, 1540),
/* 342 */   VK_GAMEPAD_LEFT_THUMBSTICK_RIGHT(213, 1540),
/* 343 */   VK_GAMEPAD_LEFT_THUMBSTICK_LEFT(214, 1540),
/* 344 */   VK_GAMEPAD_RIGHT_THUMBSTICK_UP(215, 1540),
/* 345 */   VK_GAMEPAD_RIGHT_THUMBSTICK_DOWN(216, 1540),
/* 346 */   VK_GAMEPAD_RIGHT_THUMBSTICK_RIGHT(217, 1540),
/* 347 */   VK_GAMEPAD_RIGHT_THUMBSTICK_LEFT(218, 1540),
/*     */   
/* 349 */   VK_OEM_4(219),
/* 350 */   VK_OEM_5(220),
/* 351 */   VK_OEM_6(221),
/* 352 */   VK_OEM_7(222),
/* 353 */   VK_OEM_8(223),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 358 */   VK_RESERVED_E0(224),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 363 */   VK_OEM_AX(225),
/* 364 */   VK_OEM_102(226),
/* 365 */   VK_ICO_HELP(227),
/* 366 */   VK_ICO_00(228),
/*     */   
/* 368 */   VK_PROCESSKEY(229, 1024),
/*     */   
/* 370 */   VK_ICO_CLEAR(230),
/*     */   
/* 372 */   VK_PACKET(231, 1280),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 377 */   VK_UNASSIGNED_E8(232),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 382 */   VK_OEM_RESET(233),
/* 383 */   VK_OEM_JUMP(234),
/* 384 */   VK_OEM_PA1(235),
/* 385 */   VK_OEM_PA2(236),
/* 386 */   VK_OEM_PA3(237),
/* 387 */   VK_OEM_WSCTRL(238),
/* 388 */   VK_OEM_CUSEL(239),
/* 389 */   VK_OEM_ATTN(240),
/* 390 */   VK_OEM_FINISH(241),
/* 391 */   VK_OEM_COPY(242),
/* 392 */   VK_OEM_AUTO(243),
/* 393 */   VK_OEM_ENLW(244),
/* 394 */   VK_OEM_BACKTAB(245),
/*     */   
/* 396 */   VK_ATTN(246),
/* 397 */   VK_CRSEL(247),
/* 398 */   VK_EXSEL(248),
/* 399 */   VK_EREOF(249),
/* 400 */   VK_PLAY(250),
/* 401 */   VK_ZOOM(251),
/* 402 */   VK_NONAME(252),
/* 403 */   VK_PA1(253),
/* 404 */   VK_OEM_CLEAR(254),
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 409 */   VK_RESERVED_FF(255);
/*     */ 
/*     */ 
/*     */   
/*     */   public final int code;
/*     */ 
/*     */   
/*     */   public final int introducedVersion;
/*     */ 
/*     */ 
/*     */   
/*     */   Win32VK(int paramInt1, int paramInt2) {
/* 421 */     this.code = paramInt1;
/* 422 */     this.introducedVersion = paramInt2;
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
/*     */   public static Win32VK fromValue(int paramInt) {
/* 438 */     for (Win32VK win32VK : values()) {
/* 439 */       if (win32VK.code == paramInt) {
/* 440 */         return win32VK;
/*     */       }
/*     */     } 
/* 443 */     throw new IllegalArgumentException(String.format("No mapping for %02x", new Object[] { Integer.valueOf(paramInt) }));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\sun\jna\platform\win32\Win32VK.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */