package br.com.primarr.msg.replacer;

import java.util.HashMap;
import java.util.Map;

public class HtmlCharacter
{
	private Character character;
	private String friendlyCode;
	private String numericalCode;
	private String hexCode;		
	
	public HtmlCharacter(Character character, String friendlyCode, String numericalCode, String hexCode) {
		super();
		this.character = character;
		this.friendlyCode = friendlyCode;
		this.numericalCode = numericalCode;
		this.hexCode = hexCode;			
	}

	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	public String getFriendlyCode() {
		return friendlyCode;
	}

	public void setFriendlyCode(String friendlyCode) {
		this.friendlyCode = friendlyCode;
	}

	public String getHexCode() {
		return hexCode;
	}

	public void setHexCode(String hexCode) {
		this.hexCode = hexCode;
	}

	public String getNumericalCode() {
		return numericalCode;
	}

	public void setNumericalCode(String numericalCode) {
		this.numericalCode = numericalCode;
	}
	
	
	protected static Map<Character, HtmlCharacter> fullHtmlCharacterMap = null;
	protected static Map<Character, HtmlCharacter> htmlCharacterMap = null;
	
	public static final int HTML_CHARACTER_MAP_FULL = 0;
	public static final int HTML_CHARACTER_MAP_DEFAULT = 1;
	
	public static Map<Character, HtmlCharacter> getHtmlCharacterMap(int htmlCharacterMap)
	{
		switch (htmlCharacterMap) 
		{
			case HTML_CHARACTER_MAP_FULL:
				return getFullHtmlCharacterMap();
				
			case HTML_CHARACTER_MAP_DEFAULT:
				return getHtmlCharacterMap();
		}
		
		return null;
	}
	
	public static Map<Character, HtmlCharacter> getFullHtmlCharacterMap()
	{
		if(fullHtmlCharacterMap != null)
			return fullHtmlCharacterMap;
		
		Map<Character, HtmlCharacter> table = new HashMap<Character, HtmlCharacter>(); 

		table.put(' ',new HtmlCharacter(' ',"&nbsp;","&#160;","&#xA0;"));
		table.put('A',new HtmlCharacter('A',"A","&#65;","&#x41;"));
		table.put('a',new HtmlCharacter('a',"a","&#97;","&#x61;"));
		table.put('À',new HtmlCharacter('À',"&Agrave;","&#192;","&#xC0;"));
		table.put('à',new HtmlCharacter('à',"&agrave;","&#224;","&#xE0;"));
		table.put('Á',new HtmlCharacter('Á',"&Aacute;","&#193;","&#xC1;"));
		table.put('á',new HtmlCharacter('á',"&aacute;","&#225;","&#xE1;"));
		table.put('Â',new HtmlCharacter('Â',"&Acirc;","&#194;","&#xC2;"));
		table.put('â',new HtmlCharacter('â',"&acirc;","&#226;","&#xE2;"));
		table.put('Ã',new HtmlCharacter('Ã',"&Atilde;","&#195;","&#xC3;"));
		table.put('ã',new HtmlCharacter('ã',"&atilde;","&#227;","&#xE3;"));
		table.put('Ä',new HtmlCharacter('Ä',"&Auml;","&#196;","&#xC4;"));
		table.put('ä',new HtmlCharacter('ä',"&auml;","&#228;","&#xE4;"));
		table.put('Å',new HtmlCharacter('Å',"&Aring;","&#197;","&#xC5;"));
		table.put('å',new HtmlCharacter('å',"&aring;","&#229;","&#xE5;"));
		table.put('Ā',new HtmlCharacter('Ā',"","&#256;","&#x100;"));
		table.put('ā',new HtmlCharacter('ā',"","&#257;","&#x101;"));
		table.put('Ă',new HtmlCharacter('Ă',"","&#258;","&#x102;"));
		table.put('ă',new HtmlCharacter('ă',"","&#259;","&#x103;"));
		table.put('Ą',new HtmlCharacter('Ą',"","&#260;","&#x104;"));
		table.put('ą',new HtmlCharacter('ą',"","&#261;","&#x105;"));
		table.put('Ǟ',new HtmlCharacter('Ǟ',"","&#478;","&#x1DE;"));
		table.put('ǟ',new HtmlCharacter('ǟ',"","&#479;","&#x1DF;"));
		table.put('Ǻ',new HtmlCharacter('Ǻ',"","&#506;","&#x1FA;"));
		table.put('ǻ',new HtmlCharacter('ǻ',"","&#507;","&#x1FB;"));
		table.put('Æ',new HtmlCharacter('Æ',"&AElig;","&#198;","&#xC6;"));
		table.put('æ',new HtmlCharacter('æ',"&aelig;","&#230;","&#xE6;"));
		table.put('Ǽ',new HtmlCharacter('Ǽ',"","&#508;","&#x1FC;"));
		table.put('ǽ',new HtmlCharacter('ǽ',"","&#509;","&#x1FD;"));
		table.put('B',new HtmlCharacter('B',"B","&#66;","&#x42;"));
		table.put('b',new HtmlCharacter('b',"b","&#98;","&#x62;"));
		table.put('Ḃ',new HtmlCharacter('Ḃ',"","&#7682;","&#x1E02;"));
		table.put('ḃ',new HtmlCharacter('ḃ',"","&#7683;","&#x1E03;"));
		table.put('C',new HtmlCharacter('C',"C","&#67;","&#x43;"));
		table.put('c',new HtmlCharacter('c',"c","&#99;","&#x63;"));
		table.put('Ć',new HtmlCharacter('Ć',"","&#262;","&#x106;"));
		table.put('ć',new HtmlCharacter('ć',"","&#263;","&#x107;"));
		table.put('Ç',new HtmlCharacter('Ç',"&Ccedil;","&#199;","&#xC7;"));
		table.put('ç',new HtmlCharacter('ç',"&ccedil;","&#231;","&#xE7;"));
		table.put('Č',new HtmlCharacter('Č',"","&#268;","&#x10C;"));
		table.put('č',new HtmlCharacter('č',"","&#269;","&#x10D;"));
		table.put('Ĉ',new HtmlCharacter('Ĉ',"","&#264;","&#x108;"));
		table.put('ĉ',new HtmlCharacter('ĉ',"","&#265;","&#x109;"));
		table.put('Ċ',new HtmlCharacter('Ċ',"","&#266;","&#x10A;"));
		table.put('ċ',new HtmlCharacter('ċ',"","&#267;","&#x10B;"));
		table.put('D',new HtmlCharacter('D',"D","&#68;","&#x44;"));
		table.put('d',new HtmlCharacter('d',"d","&#100;","&#x64;"));
		table.put('Ḑ',new HtmlCharacter('Ḑ',"","&#7696;","&#x1E10;"));
		table.put('ḑ',new HtmlCharacter('ḑ',"","&#7697;","&#x1E11;"));
		table.put('Ď',new HtmlCharacter('Ď',"","&#270;","&#x10E;"));
		table.put('ď',new HtmlCharacter('ď',"","&#271;","&#x10F;"));
		table.put('Ḋ',new HtmlCharacter('Ḋ',"","&#7690;","&#x1E0A;"));
		table.put('ḋ',new HtmlCharacter('ḋ',"","&#7691;","&#x1E0B;"));
		table.put('Đ',new HtmlCharacter('Đ',"","&#272;","&#x110;"));
		table.put('đ',new HtmlCharacter('đ',"","&#273;","&#x111;"));
		table.put('Ð',new HtmlCharacter('Ð',"&ETH;","&#208;","&#xD0;"));
		table.put('ð',new HtmlCharacter('ð',"&eth;","&#240;","&#xF0;"));
		table.put('Ǳ',new HtmlCharacter('Ǳ',"","&#497;","&#x1F1;"));
		table.put('ǲ',new HtmlCharacter('ǲ',"","&#498;","&#x1F2;"));
		table.put('ǳ',new HtmlCharacter('ǳ',"","&#499;","&#x1F3;"));
		table.put('Ǆ',new HtmlCharacter('Ǆ',"","&#452;","&#x1C4;"));
		table.put('ǆ',new HtmlCharacter('ǆ',"","&#454;","&#x1C6;"));
		table.put('E',new HtmlCharacter('E',"E","&#69;","&#x45;"));
		table.put('e',new HtmlCharacter('e',"e","&#101;","&#x65;"));
		table.put('È',new HtmlCharacter('È',"&Egrave;","&#200;","&#xC8;"));
		table.put('è',new HtmlCharacter('è',"&egrave;","&#232;","&#xE8;"));
		table.put('É',new HtmlCharacter('É',"&Eacute;","&#201;","&#xC9;"));
		table.put('é',new HtmlCharacter('é',"&eacute;","&#233;","&#xE9;"));
		table.put('Ě',new HtmlCharacter('Ě',"","&#282;","&#x11A;"));
		table.put('ě',new HtmlCharacter('ě',"","&#283;","&#x11B;"));
		table.put('Ê',new HtmlCharacter('Ê',"&Ecirc;","&#202;","&#xCA;"));
		table.put('ê',new HtmlCharacter('ê',"&ecirc;","&#234;","&#xEA;"));
		table.put('Ë',new HtmlCharacter('Ë',"&Euml;","&#203;","&#xCB;"));
		table.put('ë',new HtmlCharacter('ë',"&euml;","&#235;","&#xEB;"));
		table.put('Ē',new HtmlCharacter('Ē',"","&#274;","&#x112;"));
		table.put('ē',new HtmlCharacter('ē',"","&#275;","&#x113;"));
		table.put('Ĕ',new HtmlCharacter('Ĕ',"","&#276;","&#x114;"));
		table.put('ĕ',new HtmlCharacter('ĕ',"","&#277;","&#x115;"));
		table.put('Ę',new HtmlCharacter('Ę',"","&#280;","&#x118;"));
		table.put('ę',new HtmlCharacter('ę',"","&#281;","&#x119;"));
		table.put('Ė',new HtmlCharacter('Ė',"","&#278;","&#x116;"));
		table.put('ė',new HtmlCharacter('ė',"","&#279;","&#x117;"));
		table.put('Ʒ',new HtmlCharacter('Ʒ',"","&#439;","&#x1B7;"));
		table.put('ʒ',new HtmlCharacter('ʒ',"","&#658;","&#x292;"));
		table.put('Ǯ',new HtmlCharacter('Ǯ',"","&#494;","&#x1EE;"));
		table.put('ǯ',new HtmlCharacter('ǯ',"","&#495;","&#x1EF;"));
		table.put('F',new HtmlCharacter('F',"F","&#70;","&#x46;"));
		table.put('f',new HtmlCharacter('f',"f","&#102;","&#x66;"));
		table.put('Ḟ',new HtmlCharacter('Ḟ',"","&#7710;","&#x1E1E;"));
		table.put('ḟ',new HtmlCharacter('ḟ',"","&#7711;","&#x1E1F;"));
		table.put('ƒ',new HtmlCharacter('ƒ',"","&#402;","&#x192;"));
		table.put('ﬀ',new HtmlCharacter('ﬀ',"","&#64256;","&#xFB00;"));
		table.put('ﬁ',new HtmlCharacter('ﬁ',"","&#64257;","&#xFB01;"));
		table.put('ﬂ',new HtmlCharacter('ﬂ',"","&#64258;","&#xFB02;"));
		table.put('ﬃ',new HtmlCharacter('ﬃ',"","&#64259;","&#xFB03;"));
		table.put('ﬄ',new HtmlCharacter('ﬄ',"","&#64260;","&#xFB04;"));
		table.put('ﬅ',new HtmlCharacter('ﬅ',"","&#64261;","&#xFB05;"));
		table.put('G',new HtmlCharacter('G',"G","&#71;","&#x47;"));
		table.put('g',new HtmlCharacter('g',"g","&#103;","&#x67;"));
		table.put('Ǵ',new HtmlCharacter('Ǵ',"","&#500;","&#x1F4;"));
		table.put('ǵ',new HtmlCharacter('ǵ',"","&#501;","&#x1F5;"));
		table.put('Ģ',new HtmlCharacter('Ģ',"","&#290;","&#x122;"));
		table.put('ģ',new HtmlCharacter('ģ',"","&#291;","&#x123;"));
		table.put('Ǧ',new HtmlCharacter('Ǧ',"","&#486;","&#x1E6;"));
		table.put('ǧ',new HtmlCharacter('ǧ',"","&#487;","&#x1E7;"));
		table.put('Ĝ',new HtmlCharacter('Ĝ',"","&#284;","&#x11C;"));
		table.put('ĝ',new HtmlCharacter('ĝ',"","&#285;","&#x11D;"));
		table.put('Ğ',new HtmlCharacter('Ğ',"","&#286;","&#x11E;"));
		table.put('ğ',new HtmlCharacter('ğ',"","&#287;","&#x11F;"));
		table.put('Ġ',new HtmlCharacter('Ġ',"","&#288;","&#x120;"));
		table.put('ġ',new HtmlCharacter('ġ',"","&#289;","&#x121;"));
		table.put('Ǥ',new HtmlCharacter('Ǥ',"","&#484;","&#x1E4;"));
		table.put('ǥ',new HtmlCharacter('ǥ',"","&#485;","&#x1E5;"));
		table.put('H',new HtmlCharacter('H',"H","&#72;","&#x48;"));
		table.put('h',new HtmlCharacter('h',"h","&#104;","&#x68;"));
		table.put('Ĥ',new HtmlCharacter('Ĥ',"","&#292;","&#x124;"));
		table.put('ĥ',new HtmlCharacter('ĥ',"","&#293;","&#x125;"));
		table.put('Ħ',new HtmlCharacter('Ħ',"","&#294;","&#x126;"));
		table.put('ħ',new HtmlCharacter('ħ',"","&#295;","&#x127;"));
		table.put('I',new HtmlCharacter('I',"I","&#73;","&#x49;"));
		table.put('i',new HtmlCharacter('i',"i","&#105;","&#x69;"));
		table.put('Ì',new HtmlCharacter('Ì',"&Igrave;","&#204;","&#xCC;"));
		table.put('ì',new HtmlCharacter('ì',"&igrave;","&#236;","&#xEC;"));
		table.put('Í',new HtmlCharacter('Í',"&Iacute;","&#205;","&#xCD;"));
		table.put('í',new HtmlCharacter('í',"&iacute;","&#237;","&#xED;"));
		table.put('Î',new HtmlCharacter('Î',"&Icirc;","&#206;","&#xCE;"));
		table.put('î',new HtmlCharacter('î',"&icirc;","&#238;","&#xEE;"));
		table.put('Ĩ',new HtmlCharacter('Ĩ',"","&#296;","&#x128;"));
		table.put('ĩ',new HtmlCharacter('ĩ',"","&#297;","&#x129;"));
		table.put('Ï',new HtmlCharacter('Ï',"&Iuml;","&#207;","&#xCF;"));
		table.put('ï',new HtmlCharacter('ï',"&iuml;","&#239;","&#xEF;"));
		table.put('Ī',new HtmlCharacter('Ī',"","&#298;","&#x12A;"));
		table.put('ī',new HtmlCharacter('ī',"","&#299;","&#x12B;"));
		table.put('Ĭ',new HtmlCharacter('Ĭ',"","&#300;","&#x12C;"));
		table.put('ĭ',new HtmlCharacter('ĭ',"","&#301;","&#x12D;"));
		table.put('Į',new HtmlCharacter('Į',"","&#302;","&#x12E;"));
		table.put('į',new HtmlCharacter('į',"","&#303;","&#x12F;"));
		table.put('İ',new HtmlCharacter('İ',"","&#304;","&#x130;"));
		table.put('ı',new HtmlCharacter('ı',"","&#305;","&#x131;"));
		table.put('Ĳ',new HtmlCharacter('Ĳ',"","&#306;","&#x132;"));
		table.put('ĳ',new HtmlCharacter('ĳ',"","&#307;","&#x133;"));
		table.put('J',new HtmlCharacter('J',"J","&#74;","&#x4A;"));
		table.put('j',new HtmlCharacter('j',"j","&#106;","&#x6A;"));
		table.put('Ĵ',new HtmlCharacter('Ĵ',"","&#308;","&#x134;"));
		table.put('ĵ',new HtmlCharacter('ĵ',"","&#309;","&#x135;"));
		table.put('K',new HtmlCharacter('K',"K","&#75;","&#x4B;"));
		table.put('k',new HtmlCharacter('k',"k","&#107;","&#x6B;"));
		table.put('Ḱ',new HtmlCharacter('Ḱ',"","&#7728;","&#x1E30;"));
		table.put('ḱ',new HtmlCharacter('ḱ',"","&#7729;","&#x1E31;"));
		table.put('Ķ',new HtmlCharacter('Ķ',"","&#310;","&#x136;"));
		table.put('ķ',new HtmlCharacter('ķ',"","&#311;","&#x137;"));
		table.put('Ǩ',new HtmlCharacter('Ǩ',"","&#488;","&#x1E8;"));
		table.put('ǩ',new HtmlCharacter('ǩ',"","&#489;","&#x1E9;"));
		table.put('ĸ',new HtmlCharacter('ĸ',"","&#312;","&#x138;"));
		table.put('L',new HtmlCharacter('L',"L","&#76;","&#x4C;"));
		table.put('l',new HtmlCharacter('l',"l","&#108;","&#x6C;"));
		table.put('Ĺ',new HtmlCharacter('Ĺ',"","&#313;","&#x139;"));
		table.put('ĺ',new HtmlCharacter('ĺ',"","&#314;","&#x13A;"));
		table.put('Ļ',new HtmlCharacter('Ļ',"","&#315;","&#x13B;"));
		table.put('ļ',new HtmlCharacter('ļ',"","&#316;","&#x13C;"));
		table.put('Ľ',new HtmlCharacter('Ľ',"","&#317;","&#x13D;"));
		table.put('ľ',new HtmlCharacter('ľ',"","&#318;","&#x13E;"));
		table.put('Ŀ',new HtmlCharacter('Ŀ',"","&#319;","&#x13F;"));
		table.put('ŀ',new HtmlCharacter('ŀ',"","&#320;","&#x140;"));
		table.put('Ł',new HtmlCharacter('Ł',"","&#321;","&#x141;"));
		table.put('ł',new HtmlCharacter('ł',"","&#322;","&#x142;"));
		table.put('Ǉ',new HtmlCharacter('Ǉ',"","&#455;","&#x1C7;"));
		table.put('ǈ',new HtmlCharacter('ǈ',"","&#456;","&#x1C8;"));
		table.put('ǉ',new HtmlCharacter('ǉ',"","&#457;","&#x1C9;"));
		table.put('M',new HtmlCharacter('M',"M","&#77;","&#x4D;"));
		table.put('m',new HtmlCharacter('m',"m","&#109;","&#x6D;"));
		table.put('Ṁ',new HtmlCharacter('Ṁ',"","&#7744;","&#x1E40;"));
		table.put('ṁ',new HtmlCharacter('ṁ',"","&#7745;","&#x1E41;"));
		table.put('N',new HtmlCharacter('N',"N","&#78;","&#x4E;"));
		table.put('n',new HtmlCharacter('n',"n","&#110;","&#x6E;"));
		table.put('Ń',new HtmlCharacter('Ń',"","&#323;","&#x143;"));
		table.put('ń',new HtmlCharacter('ń',"","&#324;","&#x144;"));
		table.put('Ņ',new HtmlCharacter('Ņ',"","&#325;","&#x145;"));
		table.put('ņ',new HtmlCharacter('ņ',"","&#326;","&#x146;"));
		table.put('Ň',new HtmlCharacter('Ň',"","&#327;","&#x147;"));
		table.put('ň',new HtmlCharacter('ň',"","&#328;","&#x148;"));
		table.put('Ñ',new HtmlCharacter('Ñ',"&Ntilde;","&#209;","&#xD1;"));
		table.put('ñ',new HtmlCharacter('ñ',"&ntilde;","&#241;","&#xF1;"));
		table.put('ŉ',new HtmlCharacter('ŉ',"","&#329;","&#x149;"));
		table.put('Ŋ',new HtmlCharacter('Ŋ',"","&#330;","&#x14A;"));
		table.put('ŋ',new HtmlCharacter('ŋ',"","&#331;","&#x14B;"));
		table.put('Ǌ',new HtmlCharacter('Ǌ',"","&#458;","&#x1CA;"));
		table.put('ǋ',new HtmlCharacter('ǋ',"","&#459;","&#x1CB;"));
		table.put('ǌ',new HtmlCharacter('ǌ',"","&#460;","&#x1CC;"));
		table.put('O',new HtmlCharacter('O',"O","&#79;","&#x4F;"));
		table.put('o',new HtmlCharacter('o',"o","&#111;","&#x6F;"));
		table.put('Ò',new HtmlCharacter('Ò',"&Ograve;","&#210;","&#xD2;"));
		table.put('ò',new HtmlCharacter('ò',"&ograve;","&#242;","&#xF2;"));
		table.put('Ó',new HtmlCharacter('Ó',"&Oacute;","&#211;","&#xD3;"));
		table.put('ó',new HtmlCharacter('ó',"&oacute;","&#243;","&#xF3;"));
		table.put('Ô',new HtmlCharacter('Ô',"&Ocirc;","&#212;","&#xD4;"));
		table.put('ô',new HtmlCharacter('ô',"&ocirc;","&#244;","&#xF4;"));
		table.put('Õ',new HtmlCharacter('Õ',"&Otilde;","&#213;","&#xD5;"));
		table.put('õ',new HtmlCharacter('õ',"&otilde;","&#245;","&#xF5;"));
		table.put('Ö',new HtmlCharacter('Ö',"&Ouml;","&#214;","&#xD6;"));
		table.put('ö',new HtmlCharacter('ö',"&ouml;","&#246;","&#xF6;"));
		table.put('Ō',new HtmlCharacter('Ō',"","&#332;","&#x14C;"));
		table.put('ō',new HtmlCharacter('ō',"","&#333;","&#x14D;"));
		table.put('Ŏ',new HtmlCharacter('Ŏ',"","&#334;","&#x14E;"));
		table.put('ŏ',new HtmlCharacter('ŏ',"","&#335;","&#x14F;"));
		table.put('Ø',new HtmlCharacter('Ø',"&Oslash;","&#216;","&#xD8;"));
		table.put('ø',new HtmlCharacter('ø',"&oslash;","&#248;","&#xF8;"));
		table.put('Ő',new HtmlCharacter('Ő',"","&#336;","&#x150;"));
		table.put('ő',new HtmlCharacter('ő',"","&#337;","&#x151;"));
		table.put('Ǿ',new HtmlCharacter('Ǿ',"","&#510;","&#x1FE;"));
		table.put('ǿ',new HtmlCharacter('ǿ',"","&#511;","&#x1FF;"));
		table.put('Œ',new HtmlCharacter('Œ',"&OElig;","&#338;","&#x152;"));
		table.put('œ',new HtmlCharacter('œ',"&oelig;","&#339;","&#x153;"));
		table.put('P',new HtmlCharacter('P',"P","&#80;","&#x50;"));
		table.put('p',new HtmlCharacter('p',"p","&#112;","&#x70;"));
		table.put('Ṗ',new HtmlCharacter('Ṗ',"","&#7766;","&#x1E56;"));
		table.put('ṗ',new HtmlCharacter('ṗ',"","&#7767;","&#x1E57;"));
		table.put('Q',new HtmlCharacter('Q',"Q","&#81;","&#x51;"));
		table.put('q',new HtmlCharacter('q',"q","&#113;","&#x71;"));
		table.put('R',new HtmlCharacter('R',"R","&#82;","&#x52;"));
		table.put('r',new HtmlCharacter('r',"r","&#114;","&#x72;"));
		table.put('Ŕ',new HtmlCharacter('Ŕ',"","&#340;","&#x154;"));
		table.put('ŕ',new HtmlCharacter('ŕ',"","&#341;","&#x155;"));
		table.put('Ŗ',new HtmlCharacter('Ŗ',"","&#342;","&#x156;"));
		table.put('ŗ',new HtmlCharacter('ŗ',"","&#343;","&#x157;"));
		table.put('Ř',new HtmlCharacter('Ř',"","&#344;","&#x158;"));
		table.put('ř',new HtmlCharacter('ř',"","&#345;","&#x159;"));
		table.put('ɼ',new HtmlCharacter('ɼ',"","&#636;","&#x27C;"));
		table.put('S',new HtmlCharacter('S',"S","&#83;","&#x53;"));
		table.put('s',new HtmlCharacter('s',"s","&#115;","&#x73;"));
		table.put('Ś',new HtmlCharacter('Ś',"","&#346;","&#x15A;"));
		table.put('ś',new HtmlCharacter('ś',"","&#347;","&#x15B;"));
		table.put('Ş',new HtmlCharacter('Ş',"","&#350;","&#x15E;"));
		table.put('ş',new HtmlCharacter('ş',"","&#351;","&#x15F;"));
		table.put('Š',new HtmlCharacter('Š',"","&#352;","&#x160;"));
		table.put('š',new HtmlCharacter('š',"","&#353;","&#x161;"));
		table.put('Ŝ',new HtmlCharacter('Ŝ',"","&#348;","&#x15C;"));
		table.put('ŝ',new HtmlCharacter('ŝ',"","&#349;","&#x15D;"));
		table.put('Ṡ',new HtmlCharacter('Ṡ',"","&#7776;","&#x1E60;"));
		table.put('ṡ',new HtmlCharacter('ṡ',"","&#7777;","&#x1E61;"));
		table.put('ſ',new HtmlCharacter('ſ',"","&#383;","&#x17F;"));
		table.put('ß',new HtmlCharacter('ß',"&szlig;","&#223;","&#xDF;"));
		table.put('T',new HtmlCharacter('T',"T","&#84;","&#x54;"));
		table.put('t',new HtmlCharacter('t',"t","&#116;","&#x74;"));
		table.put('Ţ',new HtmlCharacter('Ţ',"","&#354;","&#x162;"));
		table.put('ţ',new HtmlCharacter('ţ',"","&#355;","&#x163;"));
		table.put('Ť',new HtmlCharacter('Ť',"","&#356;","&#x164;"));
		table.put('ť',new HtmlCharacter('ť',"","&#357;","&#x165;"));
		table.put('Ṫ',new HtmlCharacter('Ṫ',"","&#7786;","&#x1E6A;"));
		table.put('ṫ',new HtmlCharacter('ṫ',"","&#7787;","&#x1E6B;"));
		table.put('Ŧ',new HtmlCharacter('Ŧ',"","&#358;","&#x166;"));
		table.put('ŧ',new HtmlCharacter('ŧ',"","&#359;","&#x167;"));
		table.put('Þ',new HtmlCharacter('Þ',"&THORN;","&#222;","&#xDE;"));
		table.put('þ',new HtmlCharacter('þ',"&thorn;","&#254;","&#xFE;"));
		table.put('U',new HtmlCharacter('U',"U","&#85;","&#x55;"));
		table.put('u',new HtmlCharacter('u',"u","&#117;","&#x75;"));
		table.put('Ù',new HtmlCharacter('Ù',"&Ugrave;","&#217;","&#xD9;"));
		table.put('ù',new HtmlCharacter('ù',"&ugrave;","&#249;","&#xF9;"));
		table.put('Ú',new HtmlCharacter('Ú',"&Uacute;","&#218;","&#xDA;"));
		table.put('ú',new HtmlCharacter('ú',"&uacute;","&#250;","&#xFA;"));
		table.put('Û',new HtmlCharacter('Û',"&Ucirc;","&#219;","&#xDB;"));
		table.put('û',new HtmlCharacter('û',"&ucirc;","&#251;","&#xFB;"));
		table.put('Ũ',new HtmlCharacter('Ũ',"","&#360;","&#x168;"));
		table.put('ũ',new HtmlCharacter('ũ',"","&#361;","&#x169;"));
		table.put('Ü',new HtmlCharacter('Ü',"&Uuml;","&#220;","&#xDC;"));
		table.put('ü',new HtmlCharacter('ü',"&uuml;","&#252;","&#xFC;"));
		table.put('Ů',new HtmlCharacter('Ů',"","&#366;","&#x16E;"));
		table.put('ů',new HtmlCharacter('ů',"","&#367;","&#x16F;"));
		table.put('Ū',new HtmlCharacter('Ū',"","&#362;","&#x16A;"));
		table.put('ū',new HtmlCharacter('ū',"","&#363;","&#x16B;"));
		table.put('Ŭ',new HtmlCharacter('Ŭ',"","&#364;","&#x16C;"));
		table.put('ŭ',new HtmlCharacter('ŭ',"","&#365;","&#x16D;"));
		table.put('Ų',new HtmlCharacter('Ų',"","&#370;","&#x172;"));
		table.put('ų',new HtmlCharacter('ų',"","&#371;","&#x173;"));
		table.put('Ű',new HtmlCharacter('Ű',"","&#368;","&#x170;"));
		table.put('ű',new HtmlCharacter('ű',"","&#369;","&#x171;"));
		table.put('V',new HtmlCharacter('V',"V","&#86;","&#x56;"));
		table.put('v',new HtmlCharacter('v',"v","&#118;","&#x76;"));
		table.put('W',new HtmlCharacter('W',"W","&#87;","&#x57;"));
		table.put('w',new HtmlCharacter('w',"w","&#119;","&#x77;"));
		table.put('Ẁ',new HtmlCharacter('Ẁ',"","&#7808;","&#x1E80;"));
		table.put('ẁ',new HtmlCharacter('ẁ',"","&#7809;","&#x1E81;"));
		table.put('Ẃ',new HtmlCharacter('Ẃ',"","&#7810;","&#x1E82;"));
		table.put('ẃ',new HtmlCharacter('ẃ',"","&#7811;","&#x1E83;"));
		table.put('Ŵ',new HtmlCharacter('Ŵ',"","&#372;","&#x174;"));
		table.put('ŵ',new HtmlCharacter('ŵ',"","&#373;","&#x175;"));
		table.put('Ẅ',new HtmlCharacter('Ẅ',"","&#7812;","&#x1E84;"));
		table.put('ẅ',new HtmlCharacter('ẅ',"","&#7813;","&#x1E85;"));
		table.put('X',new HtmlCharacter('X',"X","&#88;","&#x58;"));
		table.put('x',new HtmlCharacter('x',"x","&#120;","&#x78;"));
		table.put('Y',new HtmlCharacter('Y',"Y","&#89;","&#x59;"));
		table.put('y',new HtmlCharacter('y',"y","&#121;","&#x79;"));
		table.put('Ỳ',new HtmlCharacter('Ỳ',"","&#7922;","&#x1EF2;"));
		table.put('ỳ',new HtmlCharacter('ỳ',"","&#7923;","&#x1EF3;"));
		table.put('Ý',new HtmlCharacter('Ý',"&Yacute;","&#221;","&#xDD;"));
		table.put('ý',new HtmlCharacter('ý',"&yacute;","&#253;","&#xFD;"));
		table.put('Ŷ',new HtmlCharacter('Ŷ',"","&#374;","&#x176;"));
		table.put('ŷ',new HtmlCharacter('ŷ',"","&#375;","&#x177;"));
		table.put('Ÿ',new HtmlCharacter('Ÿ',"&Yuml;","&#159;","&#x9F;"));
		table.put('ÿ',new HtmlCharacter('ÿ',"&yuml;","&#255;","&#xFF;"));
		table.put('Z',new HtmlCharacter('Z',"Z","&#90;","&#x5A;"));
		table.put('z',new HtmlCharacter('z',"z","&#122;","&#x7A;"));
		table.put('Ź',new HtmlCharacter('Ź',"","&#377;","&#x179;"));
		table.put('ź',new HtmlCharacter('ź',"","&#378;","&#x17A;"));
		table.put('Ž',new HtmlCharacter('Ž',"","&#381;","&#x17D;"));
		table.put('ž',new HtmlCharacter('ž',"","&#382;","&#x17E;"));
		table.put('Ż',new HtmlCharacter('Ż',"","&#379;","&#x17B;"));
		table.put('ż',new HtmlCharacter('ż',"","&#380;","&#x17C;"));
		table.put('\n', new HtmlCharacter('\n', "<br />", "<br />", "<br />"));//gambiarra para poder adicionar linhas HTML
		
		fullHtmlCharacterMap = table;
		return table;
	}

	
	public static Map<Character, HtmlCharacter> getHtmlCharacterMap()
	{
		if(htmlCharacterMap != null)
			return htmlCharacterMap; 
		
		Map<Character, HtmlCharacter> table = new HashMap<Character, HtmlCharacter>(); 

		table.put('À',new HtmlCharacter('À',"&Agrave;","&#192;","&#xC0;"));
		table.put('à',new HtmlCharacter('à',"&agrave;","&#224;","&#xE0;"));
		table.put('Á',new HtmlCharacter('Á',"&Aacute;","&#193;","&#xC1;"));
		table.put('á',new HtmlCharacter('á',"&aacute;","&#225;","&#xE1;"));
		table.put('Â',new HtmlCharacter('Â',"&Acirc;","&#194;","&#xC2;"));
		table.put('â',new HtmlCharacter('â',"&acirc;","&#226;","&#xE2;"));
		table.put('Ã',new HtmlCharacter('Ã',"&Atilde;","&#195;","&#xC3;"));
		table.put('ã',new HtmlCharacter('ã',"&atilde;","&#227;","&#xE3;"));
		table.put('Ä',new HtmlCharacter('Ä',"&Auml;","&#196;","&#xC4;"));
		table.put('ä',new HtmlCharacter('ä',"&auml;","&#228;","&#xE4;"));
		table.put('Å',new HtmlCharacter('Å',"&Aring;","&#197;","&#xC5;"));
		table.put('å',new HtmlCharacter('å',"&aring;","&#229;","&#xE5;"));
		table.put('Ā',new HtmlCharacter('Ā',"","&#256;","&#x100;"));
		table.put('ā',new HtmlCharacter('ā',"","&#257;","&#x101;"));
		table.put('Ă',new HtmlCharacter('Ă',"","&#258;","&#x102;"));
		table.put('ă',new HtmlCharacter('ă',"","&#259;","&#x103;"));
		table.put('Ą',new HtmlCharacter('Ą',"","&#260;","&#x104;"));
		table.put('ą',new HtmlCharacter('ą',"","&#261;","&#x105;"));
		table.put('Ǟ',new HtmlCharacter('Ǟ',"","&#478;","&#x1DE;"));
		table.put('ǟ',new HtmlCharacter('ǟ',"","&#479;","&#x1DF;"));
		table.put('Ǻ',new HtmlCharacter('Ǻ',"","&#506;","&#x1FA;"));
		table.put('ǻ',new HtmlCharacter('ǻ',"","&#507;","&#x1FB;"));
		table.put('Æ',new HtmlCharacter('Æ',"&AElig;","&#198;","&#xC6;"));
		table.put('æ',new HtmlCharacter('æ',"&aelig;","&#230;","&#xE6;"));
		table.put('Ǽ',new HtmlCharacter('Ǽ',"","&#508;","&#x1FC;"));
		table.put('ǽ',new HtmlCharacter('ǽ',"","&#509;","&#x1FD;"));


		table.put('Ḃ',new HtmlCharacter('Ḃ',"","&#7682;","&#x1E02;"));
		table.put('ḃ',new HtmlCharacter('ḃ',"","&#7683;","&#x1E03;"));


		table.put('Ć',new HtmlCharacter('Ć',"","&#262;","&#x106;"));
		table.put('ć',new HtmlCharacter('ć',"","&#263;","&#x107;"));
		table.put('Ç',new HtmlCharacter('Ç',"&Ccedil;","&#199;","&#xC7;"));
		table.put('ç',new HtmlCharacter('ç',"&ccedil;","&#231;","&#xE7;"));
		table.put('Č',new HtmlCharacter('Č',"","&#268;","&#x10C;"));
		table.put('č',new HtmlCharacter('č',"","&#269;","&#x10D;"));
		table.put('Ĉ',new HtmlCharacter('Ĉ',"","&#264;","&#x108;"));
		table.put('ĉ',new HtmlCharacter('ĉ',"","&#265;","&#x109;"));
		table.put('Ċ',new HtmlCharacter('Ċ',"","&#266;","&#x10A;"));
		table.put('ċ',new HtmlCharacter('ċ',"","&#267;","&#x10B;"));


		table.put('Ḑ',new HtmlCharacter('Ḑ',"","&#7696;","&#x1E10;"));
		table.put('ḑ',new HtmlCharacter('ḑ',"","&#7697;","&#x1E11;"));
		table.put('Ď',new HtmlCharacter('Ď',"","&#270;","&#x10E;"));
		table.put('ď',new HtmlCharacter('ď',"","&#271;","&#x10F;"));
		table.put('Ḋ',new HtmlCharacter('Ḋ',"","&#7690;","&#x1E0A;"));
		table.put('ḋ',new HtmlCharacter('ḋ',"","&#7691;","&#x1E0B;"));
		table.put('Đ',new HtmlCharacter('Đ',"","&#272;","&#x110;"));
		table.put('đ',new HtmlCharacter('đ',"","&#273;","&#x111;"));
		table.put('Ð',new HtmlCharacter('Ð',"&ETH;","&#208;","&#xD0;"));
		table.put('ð',new HtmlCharacter('ð',"&eth;","&#240;","&#xF0;"));
		table.put('Ǳ',new HtmlCharacter('Ǳ',"","&#497;","&#x1F1;"));
		table.put('ǲ',new HtmlCharacter('ǲ',"","&#498;","&#x1F2;"));
		table.put('ǳ',new HtmlCharacter('ǳ',"","&#499;","&#x1F3;"));
		table.put('Ǆ',new HtmlCharacter('Ǆ',"","&#452;","&#x1C4;"));
		table.put('ǆ',new HtmlCharacter('ǆ',"","&#454;","&#x1C6;"));


		table.put('È',new HtmlCharacter('È',"&Egrave;","&#200;","&#xC8;"));
		table.put('è',new HtmlCharacter('è',"&egrave;","&#232;","&#xE8;"));
		table.put('É',new HtmlCharacter('É',"&Eacute;","&#201;","&#xC9;"));
		table.put('é',new HtmlCharacter('é',"&eacute;","&#233;","&#xE9;"));
		table.put('Ě',new HtmlCharacter('Ě',"","&#282;","&#x11A;"));
		table.put('ě',new HtmlCharacter('ě',"","&#283;","&#x11B;"));
		table.put('Ê',new HtmlCharacter('Ê',"&Ecirc;","&#202;","&#xCA;"));
		table.put('ê',new HtmlCharacter('ê',"&ecirc;","&#234;","&#xEA;"));
		table.put('Ë',new HtmlCharacter('Ë',"&Euml;","&#203;","&#xCB;"));
		table.put('ë',new HtmlCharacter('ë',"&euml;","&#235;","&#xEB;"));
		table.put('Ē',new HtmlCharacter('Ē',"","&#274;","&#x112;"));
		table.put('ē',new HtmlCharacter('ē',"","&#275;","&#x113;"));
		table.put('Ĕ',new HtmlCharacter('Ĕ',"","&#276;","&#x114;"));
		table.put('ĕ',new HtmlCharacter('ĕ',"","&#277;","&#x115;"));
		table.put('Ę',new HtmlCharacter('Ę',"","&#280;","&#x118;"));
		table.put('ę',new HtmlCharacter('ę',"","&#281;","&#x119;"));
		table.put('Ė',new HtmlCharacter('Ė',"","&#278;","&#x116;"));
		table.put('ė',new HtmlCharacter('ė',"","&#279;","&#x117;"));
		table.put('Ʒ',new HtmlCharacter('Ʒ',"","&#439;","&#x1B7;"));
		table.put('ʒ',new HtmlCharacter('ʒ',"","&#658;","&#x292;"));
		table.put('Ǯ',new HtmlCharacter('Ǯ',"","&#494;","&#x1EE;"));
		table.put('ǯ',new HtmlCharacter('ǯ',"","&#495;","&#x1EF;"));


		table.put('Ḟ',new HtmlCharacter('Ḟ',"","&#7710;","&#x1E1E;"));
		table.put('ḟ',new HtmlCharacter('ḟ',"","&#7711;","&#x1E1F;"));
		table.put('ƒ',new HtmlCharacter('ƒ',"","&#402;","&#x192;"));
		table.put('ﬀ',new HtmlCharacter('ﬀ',"","&#64256;","&#xFB00;"));
		table.put('ﬁ',new HtmlCharacter('ﬁ',"","&#64257;","&#xFB01;"));
		table.put('ﬂ',new HtmlCharacter('ﬂ',"","&#64258;","&#xFB02;"));
		table.put('ﬃ',new HtmlCharacter('ﬃ',"","&#64259;","&#xFB03;"));
		table.put('ﬄ',new HtmlCharacter('ﬄ',"","&#64260;","&#xFB04;"));
		table.put('ﬅ',new HtmlCharacter('ﬅ',"","&#64261;","&#xFB05;"));


		table.put('Ǵ',new HtmlCharacter('Ǵ',"","&#500;","&#x1F4;"));
		table.put('ǵ',new HtmlCharacter('ǵ',"","&#501;","&#x1F5;"));
		table.put('Ģ',new HtmlCharacter('Ģ',"","&#290;","&#x122;"));
		table.put('ģ',new HtmlCharacter('ģ',"","&#291;","&#x123;"));
		table.put('Ǧ',new HtmlCharacter('Ǧ',"","&#486;","&#x1E6;"));
		table.put('ǧ',new HtmlCharacter('ǧ',"","&#487;","&#x1E7;"));
		table.put('Ĝ',new HtmlCharacter('Ĝ',"","&#284;","&#x11C;"));
		table.put('ĝ',new HtmlCharacter('ĝ',"","&#285;","&#x11D;"));
		table.put('Ğ',new HtmlCharacter('Ğ',"","&#286;","&#x11E;"));
		table.put('ğ',new HtmlCharacter('ğ',"","&#287;","&#x11F;"));
		table.put('Ġ',new HtmlCharacter('Ġ',"","&#288;","&#x120;"));
		table.put('ġ',new HtmlCharacter('ġ',"","&#289;","&#x121;"));
		table.put('Ǥ',new HtmlCharacter('Ǥ',"","&#484;","&#x1E4;"));
		table.put('ǥ',new HtmlCharacter('ǥ',"","&#485;","&#x1E5;"));


		table.put('Ĥ',new HtmlCharacter('Ĥ',"","&#292;","&#x124;"));
		table.put('ĥ',new HtmlCharacter('ĥ',"","&#293;","&#x125;"));
		table.put('Ħ',new HtmlCharacter('Ħ',"","&#294;","&#x126;"));
		table.put('ħ',new HtmlCharacter('ħ',"","&#295;","&#x127;"));


		table.put('Ì',new HtmlCharacter('Ì',"&Igrave;","&#204;","&#xCC;"));
		table.put('ì',new HtmlCharacter('ì',"&igrave;","&#236;","&#xEC;"));
		table.put('Í',new HtmlCharacter('Í',"&Iacute;","&#205;","&#xCD;"));
		table.put('í',new HtmlCharacter('í',"&iacute;","&#237;","&#xED;"));
		table.put('Î',new HtmlCharacter('Î',"&Icirc;","&#206;","&#xCE;"));
		table.put('î',new HtmlCharacter('î',"&icirc;","&#238;","&#xEE;"));
		table.put('Ĩ',new HtmlCharacter('Ĩ',"","&#296;","&#x128;"));
		table.put('ĩ',new HtmlCharacter('ĩ',"","&#297;","&#x129;"));
		table.put('Ï',new HtmlCharacter('Ï',"&Iuml;","&#207;","&#xCF;"));
		table.put('ï',new HtmlCharacter('ï',"&iuml;","&#239;","&#xEF;"));
		table.put('Ī',new HtmlCharacter('Ī',"","&#298;","&#x12A;"));
		table.put('ī',new HtmlCharacter('ī',"","&#299;","&#x12B;"));
		table.put('Ĭ',new HtmlCharacter('Ĭ',"","&#300;","&#x12C;"));
		table.put('ĭ',new HtmlCharacter('ĭ',"","&#301;","&#x12D;"));
		table.put('Į',new HtmlCharacter('Į',"","&#302;","&#x12E;"));
		table.put('į',new HtmlCharacter('į',"","&#303;","&#x12F;"));
		table.put('İ',new HtmlCharacter('İ',"","&#304;","&#x130;"));
		table.put('ı',new HtmlCharacter('ı',"","&#305;","&#x131;"));
		table.put('Ĳ',new HtmlCharacter('Ĳ',"","&#306;","&#x132;"));
		table.put('ĳ',new HtmlCharacter('ĳ',"","&#307;","&#x133;"));


		table.put('Ĵ',new HtmlCharacter('Ĵ',"","&#308;","&#x134;"));
		table.put('ĵ',new HtmlCharacter('ĵ',"","&#309;","&#x135;"));


		table.put('Ḱ',new HtmlCharacter('Ḱ',"","&#7728;","&#x1E30;"));
		table.put('ḱ',new HtmlCharacter('ḱ',"","&#7729;","&#x1E31;"));
		table.put('Ķ',new HtmlCharacter('Ķ',"","&#310;","&#x136;"));
		table.put('ķ',new HtmlCharacter('ķ',"","&#311;","&#x137;"));
		table.put('Ǩ',new HtmlCharacter('Ǩ',"","&#488;","&#x1E8;"));
		table.put('ǩ',new HtmlCharacter('ǩ',"","&#489;","&#x1E9;"));
		table.put('ĸ',new HtmlCharacter('ĸ',"","&#312;","&#x138;"));


		table.put('Ĺ',new HtmlCharacter('Ĺ',"","&#313;","&#x139;"));
		table.put('ĺ',new HtmlCharacter('ĺ',"","&#314;","&#x13A;"));
		table.put('Ļ',new HtmlCharacter('Ļ',"","&#315;","&#x13B;"));
		table.put('ļ',new HtmlCharacter('ļ',"","&#316;","&#x13C;"));
		table.put('Ľ',new HtmlCharacter('Ľ',"","&#317;","&#x13D;"));
		table.put('ľ',new HtmlCharacter('ľ',"","&#318;","&#x13E;"));
		table.put('Ŀ',new HtmlCharacter('Ŀ',"","&#319;","&#x13F;"));
		table.put('ŀ',new HtmlCharacter('ŀ',"","&#320;","&#x140;"));
		table.put('Ł',new HtmlCharacter('Ł',"","&#321;","&#x141;"));
		table.put('ł',new HtmlCharacter('ł',"","&#322;","&#x142;"));
		table.put('Ǉ',new HtmlCharacter('Ǉ',"","&#455;","&#x1C7;"));
		table.put('ǈ',new HtmlCharacter('ǈ',"","&#456;","&#x1C8;"));
		table.put('ǉ',new HtmlCharacter('ǉ',"","&#457;","&#x1C9;"));


		table.put('Ṁ',new HtmlCharacter('Ṁ',"","&#7744;","&#x1E40;"));
		table.put('ṁ',new HtmlCharacter('ṁ',"","&#7745;","&#x1E41;"));


		table.put('Ń',new HtmlCharacter('Ń',"","&#323;","&#x143;"));
		table.put('ń',new HtmlCharacter('ń',"","&#324;","&#x144;"));
		table.put('Ņ',new HtmlCharacter('Ņ',"","&#325;","&#x145;"));
		table.put('ņ',new HtmlCharacter('ņ',"","&#326;","&#x146;"));
		table.put('Ň',new HtmlCharacter('Ň',"","&#327;","&#x147;"));
		table.put('ň',new HtmlCharacter('ň',"","&#328;","&#x148;"));
		table.put('Ñ',new HtmlCharacter('Ñ',"&Ntilde;","&#209;","&#xD1;"));
		table.put('ñ',new HtmlCharacter('ñ',"&ntilde;","&#241;","&#xF1;"));
		table.put('ŉ',new HtmlCharacter('ŉ',"","&#329;","&#x149;"));
		table.put('Ŋ',new HtmlCharacter('Ŋ',"","&#330;","&#x14A;"));
		table.put('ŋ',new HtmlCharacter('ŋ',"","&#331;","&#x14B;"));
		table.put('Ǌ',new HtmlCharacter('Ǌ',"","&#458;","&#x1CA;"));
		table.put('ǋ',new HtmlCharacter('ǋ',"","&#459;","&#x1CB;"));
		table.put('ǌ',new HtmlCharacter('ǌ',"","&#460;","&#x1CC;"));


		table.put('Ò',new HtmlCharacter('Ò',"&Ograve;","&#210;","&#xD2;"));
		table.put('ò',new HtmlCharacter('ò',"&ograve;","&#242;","&#xF2;"));
		table.put('Ó',new HtmlCharacter('Ó',"&Oacute;","&#211;","&#xD3;"));
		table.put('ó',new HtmlCharacter('ó',"&oacute;","&#243;","&#xF3;"));
		table.put('Ô',new HtmlCharacter('Ô',"&Ocirc;","&#212;","&#xD4;"));
		table.put('ô',new HtmlCharacter('ô',"&ocirc;","&#244;","&#xF4;"));
		table.put('Õ',new HtmlCharacter('Õ',"&Otilde;","&#213;","&#xD5;"));
		table.put('õ',new HtmlCharacter('õ',"&otilde;","&#245;","&#xF5;"));
		table.put('Ö',new HtmlCharacter('Ö',"&Ouml;","&#214;","&#xD6;"));
		table.put('ö',new HtmlCharacter('ö',"&ouml;","&#246;","&#xF6;"));
		table.put('Ō',new HtmlCharacter('Ō',"","&#332;","&#x14C;"));
		table.put('ō',new HtmlCharacter('ō',"","&#333;","&#x14D;"));
		table.put('Ŏ',new HtmlCharacter('Ŏ',"","&#334;","&#x14E;"));
		table.put('ŏ',new HtmlCharacter('ŏ',"","&#335;","&#x14F;"));
		table.put('Ø',new HtmlCharacter('Ø',"&Oslash;","&#216;","&#xD8;"));
		table.put('ø',new HtmlCharacter('ø',"&oslash;","&#248;","&#xF8;"));
		table.put('Ő',new HtmlCharacter('Ő',"","&#336;","&#x150;"));
		table.put('ő',new HtmlCharacter('ő',"","&#337;","&#x151;"));
		table.put('Ǿ',new HtmlCharacter('Ǿ',"","&#510;","&#x1FE;"));
		table.put('ǿ',new HtmlCharacter('ǿ',"","&#511;","&#x1FF;"));
		table.put('Œ',new HtmlCharacter('Œ',"&OElig;","&#338;","&#x152;"));
		table.put('œ',new HtmlCharacter('œ',"&oelig;","&#339;","&#x153;"));


		table.put('Ṗ',new HtmlCharacter('Ṗ',"","&#7766;","&#x1E56;"));
		table.put('ṗ',new HtmlCharacter('ṗ',"","&#7767;","&#x1E57;"));




		table.put('Ŕ',new HtmlCharacter('Ŕ',"","&#340;","&#x154;"));
		table.put('ŕ',new HtmlCharacter('ŕ',"","&#341;","&#x155;"));
		table.put('Ŗ',new HtmlCharacter('Ŗ',"","&#342;","&#x156;"));
		table.put('ŗ',new HtmlCharacter('ŗ',"","&#343;","&#x157;"));
		table.put('Ř',new HtmlCharacter('Ř',"","&#344;","&#x158;"));
		table.put('ř',new HtmlCharacter('ř',"","&#345;","&#x159;"));
		table.put('ɼ',new HtmlCharacter('ɼ',"","&#636;","&#x27C;"));


		table.put('Ś',new HtmlCharacter('Ś',"","&#346;","&#x15A;"));
		table.put('ś',new HtmlCharacter('ś',"","&#347;","&#x15B;"));
		table.put('Ş',new HtmlCharacter('Ş',"","&#350;","&#x15E;"));
		table.put('ş',new HtmlCharacter('ş',"","&#351;","&#x15F;"));
		table.put('Š',new HtmlCharacter('Š',"","&#352;","&#x160;"));
		table.put('š',new HtmlCharacter('š',"","&#353;","&#x161;"));
		table.put('Ŝ',new HtmlCharacter('Ŝ',"","&#348;","&#x15C;"));
		table.put('ŝ',new HtmlCharacter('ŝ',"","&#349;","&#x15D;"));
		table.put('Ṡ',new HtmlCharacter('Ṡ',"","&#7776;","&#x1E60;"));
		table.put('ṡ',new HtmlCharacter('ṡ',"","&#7777;","&#x1E61;"));
		table.put('ſ',new HtmlCharacter('ſ',"","&#383;","&#x17F;"));
		table.put('ß',new HtmlCharacter('ß',"&szlig;","&#223;","&#xDF;"));


		table.put('Ţ',new HtmlCharacter('Ţ',"","&#354;","&#x162;"));
		table.put('ţ',new HtmlCharacter('ţ',"","&#355;","&#x163;"));
		table.put('Ť',new HtmlCharacter('Ť',"","&#356;","&#x164;"));
		table.put('ť',new HtmlCharacter('ť',"","&#357;","&#x165;"));
		table.put('Ṫ',new HtmlCharacter('Ṫ',"","&#7786;","&#x1E6A;"));
		table.put('ṫ',new HtmlCharacter('ṫ',"","&#7787;","&#x1E6B;"));
		table.put('Ŧ',new HtmlCharacter('Ŧ',"","&#358;","&#x166;"));
		table.put('ŧ',new HtmlCharacter('ŧ',"","&#359;","&#x167;"));
		table.put('Þ',new HtmlCharacter('Þ',"&THORN;","&#222;","&#xDE;"));
		table.put('þ',new HtmlCharacter('þ',"&thorn;","&#254;","&#xFE;"));


		table.put('Ù',new HtmlCharacter('Ù',"&Ugrave;","&#217;","&#xD9;"));
		table.put('ù',new HtmlCharacter('ù',"&ugrave;","&#249;","&#xF9;"));
		table.put('Ú',new HtmlCharacter('Ú',"&Uacute;","&#218;","&#xDA;"));
		table.put('ú',new HtmlCharacter('ú',"&uacute;","&#250;","&#xFA;"));
		table.put('Û',new HtmlCharacter('Û',"&Ucirc;","&#219;","&#xDB;"));
		table.put('û',new HtmlCharacter('û',"&ucirc;","&#251;","&#xFB;"));
		table.put('Ũ',new HtmlCharacter('Ũ',"","&#360;","&#x168;"));
		table.put('ũ',new HtmlCharacter('ũ',"","&#361;","&#x169;"));
		table.put('Ü',new HtmlCharacter('Ü',"&Uuml;","&#220;","&#xDC;"));
		table.put('ü',new HtmlCharacter('ü',"&uuml;","&#252;","&#xFC;"));
		table.put('Ů',new HtmlCharacter('Ů',"","&#366;","&#x16E;"));
		table.put('ů',new HtmlCharacter('ů',"","&#367;","&#x16F;"));
		table.put('Ū',new HtmlCharacter('Ū',"","&#362;","&#x16A;"));
		table.put('ū',new HtmlCharacter('ū',"","&#363;","&#x16B;"));
		table.put('Ŭ',new HtmlCharacter('Ŭ',"","&#364;","&#x16C;"));
		table.put('ŭ',new HtmlCharacter('ŭ',"","&#365;","&#x16D;"));
		table.put('Ų',new HtmlCharacter('Ų',"","&#370;","&#x172;"));
		table.put('ų',new HtmlCharacter('ų',"","&#371;","&#x173;"));
		table.put('Ű',new HtmlCharacter('Ű',"","&#368;","&#x170;"));
		table.put('ű',new HtmlCharacter('ű',"","&#369;","&#x171;"));




		table.put('Ẁ',new HtmlCharacter('Ẁ',"","&#7808;","&#x1E80;"));
		table.put('ẁ',new HtmlCharacter('ẁ',"","&#7809;","&#x1E81;"));
		table.put('Ẃ',new HtmlCharacter('Ẃ',"","&#7810;","&#x1E82;"));
		table.put('ẃ',new HtmlCharacter('ẃ',"","&#7811;","&#x1E83;"));
		table.put('Ŵ',new HtmlCharacter('Ŵ',"","&#372;","&#x174;"));
		table.put('ŵ',new HtmlCharacter('ŵ',"","&#373;","&#x175;"));
		table.put('Ẅ',new HtmlCharacter('Ẅ',"","&#7812;","&#x1E84;"));
		table.put('ẅ',new HtmlCharacter('ẅ',"","&#7813;","&#x1E85;"));




		table.put('Ỳ',new HtmlCharacter('Ỳ',"","&#7922;","&#x1EF2;"));
		table.put('ỳ',new HtmlCharacter('ỳ',"","&#7923;","&#x1EF3;"));
		table.put('Ý',new HtmlCharacter('Ý',"&Yacute;","&#221;","&#xDD;"));
		table.put('ý',new HtmlCharacter('ý',"&yacute;","&#253;","&#xFD;"));
		table.put('Ŷ',new HtmlCharacter('Ŷ',"","&#374;","&#x176;"));
		table.put('ŷ',new HtmlCharacter('ŷ',"","&#375;","&#x177;"));
		table.put('Ÿ',new HtmlCharacter('Ÿ',"&Yuml;","&#159;","&#x9F;"));
		table.put('ÿ',new HtmlCharacter('ÿ',"&yuml;","&#255;","&#xFF;"));


		table.put('Ź',new HtmlCharacter('Ź',"","&#377;","&#x179;"));
		table.put('ź',new HtmlCharacter('ź',"","&#378;","&#x17A;"));
		table.put('Ž',new HtmlCharacter('Ž',"","&#381;","&#x17D;"));
		table.put('ž',new HtmlCharacter('ž',"","&#382;","&#x17E;"));
		table.put('Ż',new HtmlCharacter('Ż',"","&#379;","&#x17B;"));
		table.put('ż',new HtmlCharacter('ż',"","&#380;","&#x17C;"));
		table.put('\n', new HtmlCharacter('\n', "<br />", "<br />", "<br />"));//gambiarra para poder adicionar linhas HTML
		
		htmlCharacterMap = table;
		return table;
	}
	
	
}