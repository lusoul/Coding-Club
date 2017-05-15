package com.caden.test;

/**
 * Created by lusoul on 2017/5/9.
 */
public class SubStringTest {
    public static void main(String[] args) {
        String source = "abcdabcd";
        System.out.println(source.contains("cd"));
//
//        String target = "abcd";
////        System.out.println(source.substring(source.length()).equals(""));
//        String s = "wctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofwlwctgtwmxnupycfgcuqunublmoiitncklefszbexrampetvhqnddjeqvuygpnkazqfrpjvoaxdpcwmjobmskskfojnewxgxnnofww";
//        String p = "rstvvqxwwytlhtmddecbeluloucjbnjrltxkwykjehlpnioghuarrnitpgbxkjvenuphpmpszyospiyeitiyodcpnynckdqxozqmgghogviwkauvzwjvuihndwnrlloucyqtppcrdhhotkymwamdqldmtnldlggfbfoojtsijkojrshbsmsmgtbjmggdfcfdekinrctgnuflwczcefledrknbwmsaduuqmlcbnzqkfvvghyspeujnguhillguzbfoshebuydkpsojvxcuirihjidvjkjnedhgmdlxbabnlbdtacanykejyahlkkifyjrqrdootrbjomjbgglunxilrahojxughookuhtbktanideubykfldptffrqazpqouexopcjwskakvpjfsjfkwdptdxerdgbkvjemfmpnologehchcwjqfwqmrodnsavyqyjulkedicuwwkuqtflpykmdxomrfwavtsehwqfutezytvuyxeyioljqmkkyyvnaltuhskpcsrxemjwlqauqppofkkhrwjjxyikqvllqjcuwlkxyvvomkbclxnfufnxwephybchgmcnlcnjhqlfcinuikqzeeiupmcxbhsxkhooxgzyjppkdnqonfcjgvywdduxtitbvbrzuaqkvgkeukhnxdpniyrofwbcvszwrhdsjnjxdgmozyjmmqesmkmpqkachcczlsmvudxnevhprzvurwrjkwchweosteewlufwplswtcovjbglmataxbgxolcjkrmuhrshrxtppawguptnnkchcsdorotbrixvdhzuyqyquyllijrnqdyppasqogtejplkosjuyoxmpnmeciykzwhafecdthfzqptjqleagydeixkzuceniluoarzxmdbipvqhrgukiyqpgkaqrxkyyrixhpiijqlmylikaxprqbbbrrnaldymccagmmskisbgnxqbvqvdnpaonwavamtwhcumpdlawgbrirzggddhciauwvvvesuqokuusjolfilheeerunywbewyvooayegiscyrcjutxkyovrztmeiwkbwmxvgzkcpniwtdmtmnzhzxnqnaterhyhajnzddnhktvfgfxjfzwlspmkbpexsycykwhycufivauovumdnkmznbjkocinyjqocxcerxsuacozbvckflnhwpitiypbnykcwuvrpbpdktpztmvaqqqpyxtayouyyngzyszorrynhzcxkarmewxbjzkzsuwsfguwubbffcasxozaqzjiijsvnkkbgmfrocfmkxypefvkxnfhdoqrxmibqlrcnnkbkyghxdkbxabtefhxithrbhlyjnthvbztadudjkpxpdknpudwltdhjtugzujnewmkxdyocwmhndebvoiderilgmtdwchrfihrmmztglrvtuyhqenpbnandznjevgqsuufcdcnzbwohrfapfodnqrnlkkkmuthbjkiddbcyrtqolaxozopxwapvwdnzoqxfjczsfgsiosahqsnfzbdkihdtytvrrrmvlymywcbrvssqpbqbotvaqpqywebiyymzlpguemcgwldxjrtgegobaocfqibinyuneoyzyghexdhnjklaabaseelxetappktcidpvigmeyfdugceaviyptgrqfktwhlaholatcnrwkdkpcsddxtfsqbchnbazlvorzsmfflooecqcyonqdkcoxdmwtdkzfwhnpexrlykytramordfiecgmyxmdrmaalvseklmtbnfcrbhcmgaluxdvmyhflxatcgjejclgsptscqgdemouqisubthcluerdhxhekelvenigatnzefhbavmwajegzqxmmdhgmlmnndbnqhicrrwtgljgirobgexpmzkaklgryrkueolokwaazfxbfbyrurzzojuoeliexgwvxcwrjvyisvvzsvsthaoarrgykkrezkknlxgcprfruhxkafxlfepleqvpfptheypdqelfjteqvtpmxnuyvxqmjprcieqidceeqdpzylpuisewzpwujyetvavgvsyknglxdhmrnnuxfgmqzgheljmugsdrbreckdynrmuegyurtnwhplcziosbjegdaygtshhhibqsjgfywnigbdjruqfktbhpptocpaoqdmzeluqptljcyjnibwtqpkhwvqgiwgrbdfqaxumjkdmvrrhpvbyuwodctkzoxqegosuauqwssouhejzqyeaidtshdcifdngnxzejshsdojfxxmwioqqctcchdqtnmbacoqtjxiaymkxbznwezpsoonlluqawvezoekiwymibqudloejfoqvygcoqaokoqzopyqnyywuntvcvxagbktwwmkfkkvguyepmxkvujczbaooskewkvxykdeidnemgnbhypxpzgkifgxlxkttrlpyjnedsbhdkeurzefnrtikmrglctmlrgubxsrqfswbyeiwueymhqoxnnmgjvqfdramurslxfokenqlxfkmbbuyiwlyuczssxidjedkrrtbjnjjovykqyosvjzaxhqtnzrpyxtzpudmlklwvvvamqdrjonmtrkaghrirwytupnbpvfgvuecujtbsrlndafiqzijiqjkrhuqluvzfiibdydrzjmtqhygqwsgjhhwnubkbqpgmzdbtiuipwhpvpcmjfnvbftfvlryzphvgxkvzdalznizsbrnlllwbezeqxrrkjfvbqhhqymwykacrxqvezkktxaftypzqthkplgrqbrqdlcmnvyhwuecsbovrneuzxmtpfrcxbjozpoqneifyrkvrrrgcgnniwvatsincxnxikcfpghhrtgqyldbgvzjwfxgdrqhkbyhbcmxpkayhcpxgrjhtpmvtztwizkuwdyafphdujphgsikzfcnsddwldyzoefiunwcndijukmgqhmfusykdprprxjmsrqkkroiyuziaxxvmrpjnvycfmprxkeghhtzlrbznwjsjvmhifbmxomlleuqkmydilxkisgktfjgxmeskqdqapszefjaxmzswovzmrnxnrmklmzkgiijywfitfjqaunpwfiimwnwpergctopcbyuwqivtmoyzqdhwlmqpxajchmzlyipavbkjjrtuarwllkhnubhdmomtxpzhpjdktonjzivmadfgkipgqmqaclttvqmxdoqbtcrcwbktrudhgzrkbgvzfzurwhenisrsghiltsblblmmrjeyixsrowtqotbllbwngtfvcffkpbxanmnmgbzqbdawdytgmsaqnldkrjrdcvdefxhhwvjikevbxoxmfrisghtppxmaisyesluodaqnuvzhiyjhfgtdspzzqbxzikhflmqkojbbapugbrkinslotdmfirjgeblyrvfufckzjrkwnfrveytccjpwvktixalpekygtunleysakzbcaakjsgbszuqeoidqqeypfcqlkbxtkpromxcpzavqvhkcgrnzldjqxvtilennmgwbvmezvbacvdjeahzhdslnqtejtsncdshjxrwaldmwggdmefgshazrfuvrpilvadzznatldrxxhsnztvvqdifjlufeacighttujqygltotlupvgxbtdiljfaprvxytkrdlktjfbceyrkvyqnbmssaucoovrssmnzboqmvpdqsionefmughyjlyuupjyiklsprjzgcdykmxncszrldjytrblntzvdrqzfygdwetkjzmppeyjluvclcdixqjuyjhrqqpqhuwzmpikpfkevrxvybjpnwzbgfwlplafbslhjwlvommelhwbzibqgcdcmnbnhnttroecgysjvbwizfhjmzyddgztzpydchhxbfcdukhrtfnjlynqpbhprwmontrjdloxdfzlnqbfmvglrhmaohjgvalxlxjjvzsuifyffxpsijfaovkmeabtkpxnixplnakjohobcnefuowlvmiwhdfabienqkjgzpaujazcyfnhrtbtsbyhnocemhtknzizzootmmkljrxhdpvbsynasamkamyjiryreysoxgognbqlvwldnyheaocxwmtnpdsekajfezbjujluigkofjmdkgjybcsqszvbvnyymtkqdufitvewanelrtxzuefunpenjmquikxlpcrtzscautvqmsevvkcwqyzdvzkomfahqcdgmthfrrjxmfuyonajvzmwwqtfcvhqranfsjbgqjvwvejbjlljenetqredxczrcshkuokhlruidkontvlrpwuxmmrgfigecbccqmnllrjhebikreubnotpjskfwjrtjeoqzrzwmobqgeryydlpqvymfvskeelyaiwcfkizgemqkvgsicuekzdjjxuspjthhyulwkrflcuimmmcmzgeghteagnhbbgrjsgboymcwusiphafwznxhtrpoblnukrhjsdvzqtalfhqwcnzvbmobzrivqjwuifktpfdchuyipllcmjoyemscundxakhconhibakifrrobrwlwnohgitbmdqyqunviwcadwczrkgbtafpjeltxpgxknsmmxpkzynjejhwqwiqgwaezryhpqgqqfeovjgnzhaaezabhnszorllteinuolfhbigrqfziuwlthqobrdrsbbbvgkpcbtrlhrveqzrgnwkzxvrgvcegfvgwnilhfgdsomieifrmkylrmqttzbfhvtgxbwwosgyujlstydqmtsfrsrgxpurukwvxwsbdygclvoqjwkkvhkswdobtgneskssdublzbbsxmvcjlesjhyvbwleliiyslnrsgnirwwkpdlgnwucztfxdmkbdmhifdprtvtgbemdeaiszkzhrvvpyrjeqdfhsileounkxffonygsimfoqqechebzvudhqqzxgjijyqtsgzhudwgnxbaffwornaosxbkazgbmkrlcnhyxzmxqzrbwkbkcuyhzbylajdfvzrbfgiyvvxunsvtpauljveopsxxxqxvanqeyxfnelbwzlldnimhhpdcxqmgtqeeleljvcyixbkdansetowaugioumnzqiqzfgblzqdworivstolpcykjfcijbdqqhuiowrypucogvjnhjogdlxtgnizpqqyjdlsknflrzackyavppywrzdcgcrgmolnymafihgshdtmfgpzmjucptnlkgqbhdobsldyiluxvtphgaaherofshnllsgllhqhogupspzdckhpkqjimemxtlgtjmpaofzwndnpkfgopddqeombllzrozgfqeekcgzbqhcetsxzxmzxklzvnlwktlfobonvndzqnyvbezkoabnrjtgioppivmqqpeymajwunzwretcjttildozxqipznvilxrzrzxataroctfllxpbsebtuhjoutbjiyhgnmzwnqasdufbdickgmicwpynowdgehoqikaxzynrqbdxxhymfncpgqozqtqgzvzyfmslcupsnhkrzcwnmqgdfsavohvzazqatuqpxwfuttrzsaofpawhvsmipxvxvyfedqdhbalxtanejecbbmlnspsaboxjeppsmghputjbmelxrpvjuoysvlbwsofkkvnzacluegaiqaywdvggckfqlcanekpniucettsmoggiemgyqxxsrheooefzdbqfubemxcwusvrpjdghvcnmkbrfzcyokiyzisxjuktbcupxzpjhwatcblyeeijffkmwwruwijjkauobwokgpgdvmldeduwtghhmzslfaghewbnoerfwuxwgldqnwirwrsoojjsxcsvbqtwmvaxhcwskxskxssxrpspigypytifqpakojzftwexmgwsfiffaevdllauucdjhqlchqaylwezurxzqeraesouocqkdbqvxgrcrexqlhwtdwlhwqolaxjqhywlqehptfcsmrhzfegfoqlskztqoszxkfmbowbjylgpblqswwcxuyheijaefmbawkygywpbjahrqxxiwspwdbyixctsqluukxpjtkkwxoxhqtgrtnyrcrfdhapcxkfhwvdlwetfwhikzvweeuiuvsdsztcapqluqxmmaczrmnwqriccvgmmrsaturedfzrfijwmylitgvfdehrbbclhynwjcrdrxmgxpnchzquyqoqbktgugkdrrjwtqzocmkcqesjlehqgszgysjpmzfjmztwuzstrzruddzeybwagexchxpdwpeaktutyinjcgkxkhbzraalwfyfapftrcvycjvjtttewspkhtzfwcyvqjrymokzduocylwcsnkqogibpzpcavlylcicwedfvguyoexxykptwnwfljxkmmajmzfvbedvjupcbbseeoopgevbujgiavtkztuopxhpxhryvalloikwnimuqrufrcbptmezbrzlzncisppuxnthshgfbbqqctxmfkuxtsqxzsiejaprtcuxsggljrfvtvhivtnzmnqspegwbofsknugtkbcfnqvbezwpjvvwagtkuzxufikuaadyljecssyylezgqrnlqrrniqttbwzgbvfxqlbiruxqtumuucjwdbmokbpelrbatmmkkazsnevbtaigzmkyayipufpxzeqlhsxhgbyfhwapszhyfzpyyambanjvibvwfrhexxyohitjdnbklxubplbvbyvkgcgdnldxpdkbvnhfoirwurjuewljvskpmfnlzldpxuotmvgqsbtfxhexwjxmuevhzyrujushoaqpocupphieywcbdobpwctmmiyvznjtkrewacapfcmzhnyhrjrcykcifycelieifsluvzprvjiqxczippcmjucxverwsormcgdpbvzknfdlygymdcsjymighprqdzkmpdbnstdrqdjblbohztqbwzqpqqmoqjmpejpmlkkcasicudwmivlwzaojvyusoetpjjyvbjwncigkhvzkcdrfnjjodgjohmbzvrbsemfscokwgngcaedwqutsqjlogqcrtarwsayntzlwwyhmdulsuhwhjvcwzxgasuhjbczvhcsdvcispwfjjrmywsemfdijjivmkolonobzwpoyytfqlpveidclrblckgvwenlwddaqnfmtzlgsbpkpcwycrkyarqbijqyimiqorfjrjzulwivsfhywnavzyoyoqrahbkznvowlntioypldfaazwreonbtkpoyxbdsvmynbpvwzyubfeqdjqmsbtqdyieqelqsceulcjjzahdihyekmruvpfjcjrwwqdqurwwyifvcqjstzqpwyviqhsnulholfavxnkcvqkheblfyuclbrzshaqwbhzxqtshfojurxfmgpajyudvdjelnadfqfniayatkqaqaszjbgyyqznyefinohdxpejogsdjffcvijmrtjomtojamtpzpgxgadwxfgaexbcvporuwpnphbseozraapldxelprladsjcktylhqfoynbyripybstkfknfqnjtniyqcuumgvglpylieicfjxpgtrpbuvuenljyvnvijfkawkmgeoypgckhwzqvlxgzlbbqietgimvqtmxncnvgpufeapwjzaojeencseqzhzdnhxwughidbhuqnrotyeeoljzxjaamzrcmxhvscdjuxirruhndavpzfwxvrppwzvggwvkiirggjfjjbqctlqposdkkxjenwftzljpubgehlbkhmdwdkmnoriksqdtksjqyylersqdyijuknvlhfacggysnehzupbemkycmlpbleifltmwmuamcqldrdbbucqlbuaptstbntbmshgdanpmuqjzfwcnngvlgqnscfjksgchysqyphaanwocqbjjfpinxaernbojogbrzytyisljzcaduvenqungqotgpfzokgxbyxuiyamfuwpretfofmfrtgewwvorrrqbcqfrauzjwjyskacjfovmtkdsncssytwxgrkderqxqvntwsrkjynrrbneqekevhivjqoqmtszhutuaknbsioytooglxpivwvyobaaqwfstdkyczhgodimvxgfvrzxntygiooedkmcrveujaupgiemzeoxbpmuspzkpmxoaltmalyjleodcjgwkgjjobqtbzqoxgcqeadccaouggbdxzqimafchcknlotzoywzgshtnvznahsauujpmfpklqpdvkuusvixzfljnerdbwnbpueninsrkrkhkuusuutbgkezsipkjludywcbdbrgaueqrybiqsoxlawqcuhpybnkgymbplykbroxizfnpknszoclsujcytidvrlsydjqvjjzqjyccskcrzuxbmpglmdyqghzuadgzytcducndmhlcvuvxtwchcpvaccjtdsxcjqrsffgxzgjmrwrfuzmqrjufcqoicnxkdnxrxvfwfeniipjwwootbxxvdpfycrundoidrkwhaqngtlgogniqekmckvkjhxtezvowfrhefizlhsobjsfrcsxrxqsrekkepimfdcwtckxjdlflhziftclphgqqkfjwhzqrnyowmeusivizaecwbdfkwwueiodkpogccamsuesarnsvrffyedfwqoegloesecdeunhlynqlsbtpdrgiofqxltlwzwufbgqbxrcokiydhazqjuhtihxcommxzdrjbzlwcicxnrsijpvhdjktdrooismdxbrklkvpslebqcnjrrqngwkhqseptwfzocwdlnjjvulewqhkvhosoexgntycmjfiqklrumkhwaoxkwvzjzenenzmboeztizyfcvjsqwvswowkvsuksuzrtwdivzinqujrkvmybctbaqdphgmsztxjrsmvievafsgsyaijzzreaxqggorhzfysawuoporjqarjivbcugnuxaoawiqpspqccchjevkcszmojwujvncapiklzsuogxkiahniulbpeinwqxagkngrkqditiunzyvtiqbdnxndzggftlbhwpjyaumhwfohavyfityargqcavusyziimrgsxtvanjqugunhzwatklccmbvevkyiivcyqnujlulnitqqgxsarcblcuirbtxakupvpszrfgynonjttubbepacmipqlhoztcgnliniqjcbqkwfxapkppxfkxlpmxpqyyimiblivnyvmdfwzxzqnzljhruweytcmktaxpmurkynjydrfdyyhhvucivavxvipqblxoenfgycdleznucojoycxgruogozk";
//        String q = "mrezsglmmlgmmcgdydapulkiylyihehkdsyhjcpapsczrdysfludfjymclnnmqrwthprvgaofwdveudxsajdbamsfhzdogjpyipsodvetzuxfdftsdvcxgjivnixecatdjkpsrsjckggwtsejqsjxoqlevpgxaapfokdvczxheejnyoidemipgttsdoesenevadfhwkqlhqozasdhzxipxwokenqbzudmjklezhsbtsgirmxkfgvkzuzjccmwpqijmuslfpnfvjfuxcwcjuebplopwkzuojuekrdzloriorigyjqcqhuozzmnpkbqrzmzsvzttkwhbqfjckzzhmpivvsdmtsemhsrrmjbfbmfwrvbejimrtettcbbomfdemljtoxrjqmlxgtbzqzauxghunezwsjyvwanqlejsdrxvdqnnehqxhtqldgbuyfffzvskruyifxaxraxuactfqrlnloueutgxwiwpfnsucnsdaonizelnstdjboqowmfvyuinhdpocnyusdvvkgezcwrbjbcgdinsxcewqgytjwtidfzkprppibtriavvoebdhcdbzfucpclajgbfxzduwbfpstdkjmgzasrcvtmybeorybvsonoysucqjcnydqqfjfeizgmcmqnmamkfeyzkwhjbpgdytynyiyxyybudcbjgxbatvoawdntogiduohvfxmlyjpgiubtbdjkqxzkvjxzgfonbgnfqbntysdpkbmxgmayjcxzmaoctkystcmpoufqbbmkbhjyecathgitdwthmpsxkzdsxcuxsetfceyewejdvypccbxzkqxekgvobgflrtooqrnjqsiwtxddmnknlbzfnvkmdvtnhopqaxclgspybnfsuhbdvqywymgmbcnnpqnjsfjvcohswmognngylbeooxejzlyyzlihgakrxxyihbtbeooxmpvwhvlluauthkwauhkgzyfqqncrmlsuffljaiclamzhodkcfduwlyswmpnscqedfejecgoytiehaagvdjnfgwwoamsscrquxyyjrmdalgqwsymhdgjnlalmkvfvjnqhucbhqqdygwgiaipwzjyxmtakwskxcmjybwmpkzpmciczzmrkqzyhgafrjbhsrqzidcnjsujtcaosuhykshhzgvjzobzgvlsbamgbmeqzrzohteuivzkwxskdoiuiiqxzpzdduwfjmgqwatlcttbgrjdkpurhyxrslezvptakwsoghdboyzenahgqgljcqaeboiuurdtzfyypqgyzixhaxejcnmtkpaqgiogtbvxvbiadnetmwexyroawcaiqpjnssitckwqolbbtmetbytqbpgpzvtsbvvnmfvsvchdrzrdeysykndiixbwrrrcrpllngorimhlcgjsfyrmljwgrupaooczznyjlcvhdksrrfojihqlaveqlilofkdmfjuommezdxwptxtkwjdfeutjstgztwxuvkgfoewoihnhifutrdmzwfmyidjwocrbmfzqavxfdtflxkcieewcnhnzjdruzxtpkcuxfdbjzdrnaxttdezomzuisxhmsmdzzlpfyrnhbfcgzpbptbtsiwieayumjfhnwttlikhbrqfdcbeuvatfrdundarrnvlbmvdqvkllfyrqvaimjigwloyzynmcylozzxaqendgqhcvgmyvdlivvdvfyudfijchgytklknpuwjaksqfuaguzxoxbhojjtclhesewbamfpxhqgnhmayuazcthrwnqvoealbhxklmayicrybtxpfyesktjpbisikwbmwiturjzlqovzdmrzwylyjpoacsqdowfdmpemnrfgemgjjuhjfxbqqfhevkebzqzkjibsuffrghmcswgsuthajqicfdoujrulalzitrpgynuewfqbqqpjakygecvrxlzqzzicjtfvxijskxhpuwfqzcfrvktdoahlfhhofoefgmstvhcgbrnvejpqvqqhgrmtnujbynkjxobjjlnayxjqqdcjhxwjokgfeinutctopzmvlexquyaasooiknwhjfnqzzujgibmoduexfepbrjxzvwkthhctanlngkqdzanklxygxfkfcsmojgynikuyiywsvbzashqrhuhbgcnowaleejsyzuvexriojsjztvylrjizkftmgdrplztzdzxtokzhvqtmebsvaqeglmerezohubkgawrolfxxaiqnxhelhoodrefaconcdnzikyinpwhxmevncaczpoburnnpdetnxfjtnlsiaxzpxbcsqpzeqaquccxpynxbaspwkmqnykdwmuidxtvvgccixeepktgrjixdemlfibbpddjmtaxlunwqlblzwsodrfolwdcnwbocpphtsximijqdwdgtzerbgxalqiadpbsyktedqyriovaehcmpmshzvocwqgyootusrdbjqqbghxkliqezqlgcgifywtmagyamlbyrjinkgsieifmizccnsauounmwmrtrejzyortejjtaartwnisqjqvfdvfpbmsmcllorbzrfzitbxiuxjjqzkhxraailrjeedmopzsplieibbadjwtoenpmlqmeuwhbddezqebexnrkhahhpotdknfbmloqyenfkefnrdhsvmtwnyshkpxilhvuvtlfabjpyogicukszaamthliqudamdelachryblaoqlhqngqvtxaxtatoflhcrxphosmismgxnonvdqkmmaqjllnypmmavpnkkrxyrhfnhpifekuaarwghfaqkptpzoolutfmmylsutmqjzqksjrjymeurmtkpeoozxxxuomrtsxcyxclbakvastgllixtlsimhctqlizphgbvvbkmiyypeebzcnbunwfyxgatbimcvizkjbdmzxoytjnnvcssygyyahdfkqytovdlsaibtkvtmvtvtceurymhheiaklwgtdgjnmhtgfhepzcezqynwnvagftyxttcjhydbyyuxkzehnablwgzbufnwihozimdprysgeatysnsrnglpcvwbrdewwheidtjcrxiafoliorkglzrqpnwivalfflmbenftimxxnswyhupipvizeedcuocybuhgakswipeddxetooulodwlsxanzmrcoksdgwtbfiqpbbiwaovkhbpmjqrzcffwkveanidackilkzukfwxuuxaewndbzaipxradibibajdjgbddvcgfedmpysxpgimdokkofuhosrjgswmedlfcwecgsyjqbjccetttezpzvhztpckhdygddzclndojpbgkcbqjoummrucigouhxmcrwtlzdoltobvixxahpyilnkcugprzttcnevcsxqagoaycxxkqmqztotooypbhsttwcabuyghkicudlkloermbfibabesylbpjvpqukfjjqdkcwebuhzfhboguamrnqpexaojwzgxmlzuqznphfzccdmamxshvlzvufshbpytzonpgtqvflklcqawzeqhfkfcnxsidjizkrpzhhtbazvuhhtnehktiuvgkgecgzfrushwhfwqyfpkprrqayipflltwrkvlfyiihsdtumgqguvesbimoixqpuczjzcbtuihhoeyrosvunhszmljhqiaxzpclesxdedchrkqsxtzyholkfuxlyfajjziqiebsmpdtubogrsycwilvekhubwigrrrhhxfatisxjcpshxihrcdpqyaiwllmmvdxarypcuhbvtelxprzpldzxmprhbfkighziejxptlardetdrkixhevrculrxbrrxyybibipevnfoyxesxlmfjcdpdykmadbpekoqichqukontesnpoqswhkrtoxcrrpqhlnvxhdpyapycyjrkhbiuqvccbruihcsnnplejwkpdufygtmrwaxnhwpwewovciqkoxsmfupdqkctmllmhvhknjagykybtdxqhkyssxjmcrmnclutjdddotmuvcsqaohlfdycfvcgnkrzukroujgrceulglutzddqpmmawywmnnotaqocxoluxysxadztkdwbqqwmjdrqhtamzpqlkqqbakkytvzslslllesvfvwvmsuiwrwgjlvtwtdlercgfslhochtdtaqwtytvxopnvoqysbrswzuzuqihalnolkmigpdhmssdrwvleplhdrivyzjkvhxurqsipkpmjnttuazkhyiubbcnvjerluxxuazcrvhvcztrjxhmxttmdaonuuviblgtobnmbnqbcuzdbttrceaddkpekmqhositbldwrzylwtrmqbtxautrqzilmqukobmfzepvenoyectksyclpwalmhygniwtucybcqdhzgviujcookgoktjjgdyttxxxjknymtbobvsxckgurocjacdplgwrjkubmlxulnodfmarhofglxphrcaorrpmnmvqxfyvapbwjebmdukpyvjpfnefonwdejvobryqsdewoqqlkdwjqxfmgxkkokrsjbgrkocyhitnpnbunykgkoblrlefcyyqicgdgoyqyhrvvsxccqosvtmsnafxdfubhamcvwlxheyrxbvbjgiacsbxtkvbvonvdxyyljhvvzjfyxphbjzsgabyslxozljiujwdkgvbcebenkixuqvomftjzdftvxuncxfqgbdalhptavtjesuhfsdbjlwsstvjepherstpvzzzrlxgjgsbmndbdffksljskmaacjruanbbsmqdcngqjsafcqltzrgajzdwpkolbqdlkdsypyqaonrxvguhfyqkpsquysmwmqzyvibllenfhzhbqlbrqslwweybzghzgziwjsrymqhfqilyuypgdbmteilakxdqyblavconycshghbbnoawlgycklvyzhziqvubadmgxfiowmxfyobftktanoykmfnemzxojngfsrmuzbeuttlxxshodqwemwfxbzevibeppluvznuvksrluvcndqflsffbttwjcrrmetjzbvxrlqvwpkbgvqfpcdsmxaddvdyoszbtvovxhhwctxcmctzspgsuouxtqtsasjrevgtuintghkwmxzsynihsasajlczebgtrttuditewzemoamcmnujcuyejuycuihjkbirieadvtmesspmbmsfnxaauhdyfcnnjflstgqhlxzuyxgsojxnwhwaqdnpgdmrqdzaxvlyqblcpptmtpyvihsnocqafxclffmpdqyytwanbbroeaxoawlesaefcazcfgdpbwuxtflbgfnwqechgzidbiktgstcutgwihjzpkfazyepeewdaxuiokxfwhitebimeuvaddtncfycffqkprxrzzzxvttrjiwejgwsrmgwdvblyviolxgudxrwxgzbxycuuagwdfgdkejnbmtaoiedltaigrbwxzzinupelcpyaslhdhzeyvyypbsksvkodiuxuepbpruxfgininvnsvnrfylxdlqzcgnhjufkwbiyldidlnunexezdhmnkaxksynjiepkvwdzwgrtfflxxtbrwcurcrhpbysbauphpqqbfncwdqdntbkucrzwdcjtirapuzaqxncorxplscffuvmmonyvyuzjyyowwhpxvjbfznnntinsgtqxfgwffkroruyrvbtdyddgqzvxxstadhkclabcarhtrygzlcknnybfddgbcikipwtsbmeunfoxrpkiczmetishvmqfsuuzalmpnijrnpggextlqecsgmagzvbamjnwupryevlclebtfwrcnpenkqctmtpuqhuddfvrlketbghzmfdoxpwyokaaivcfmfxzvrhkyxpqvamkamqzbpzlosiqtlzsljvhufutevwdzgkmspggqvliivafaqjaisxeuqovylsjltxbkrktmcqzqhjosbjwrrorojvgqxpokusgwgnwbumaxoqitlyuwjkdnmrddcjqnerwjngmojhwnowxgtkmussutyzuimwppjfnxohlujggtpkauxwcjgfrqqgnupazkdneokwnbrrblkcvmqwinygjfluqmqptgixyonqdxwwkqrrxemsuxqkzrnexdmtgzneqsxzacyyhdspvmyosuetfkjaavdzxfqrtsoxshryxcslxynxnnujywtlljdxjqlxcjwksyndkjmpunpuukdzzjgoqqcklzhjzvcphoojmhwaulxmpczrkdbzegosvtuqvpevcmmhsepircnkruzkqcfbixrnzyjqupaoossuobsnkgmkvkrhbmywkbanceibadjhiedvuimkyazxnxckqlhksewgcvwfgznsavjfchmfnnednfxlebznmeqahlfklhgdnfvatphsilsvxeteimbpduforqsjvcuwqzprflavfrjgqxnhtqitsmytkbsmzsgzqyixchhynvdfxvzuzfmgifymntuwohncjdtmlqknmifngdeuktfpfggadkxqtovavvargtbrfgsmqgemlmbjsyixnixxjvojwmtapoaqyvcajcicwsoyzmuuqgfrxnpxatsvdpyyxmjhmjmujnmmblzfekoupzauavqtjabrxrwsjodffrthfrljdrcexfdkjtimpitqlrxeoptbyrevxrsmzfbvroizjwubwfucptmvfzgmidnpcmrlruxgygkhvhvtgdfvligignbesbumxluvmgdrxanqaigxsfwillftepvwgibmdbuqfawlygsjvenrnomjzsakzawkhjtxyuoprlcixekcijrkbfccusenfiuqkbmhsziatptxsuzldpvoxnnxjpnbupzfrsiqpfsqangxjdjdznzvcmqmelsrrqjtotlzzmcluhxxzbdwcjppejuvelpcwyqcibbtlpwoxbyoqktmksunhfkaswtqwuhyyylcinabrlbctmitbcbgcwkksuehpnrlugrbvobxybflmztdncnspfpbftimjrweeucqmphsdutowotzyfkmkaiuiexcyvvmhwvuunnetljglntisywsncjoiiycyxtkxrpmxyrvcygmcpycpacqafrljtlptskynazawhykrzdodihtqmqaoueogvfzahhhaonwhnicdrjpkhhkqgfxbathspycakizmlsendyipgcenyxkwejpesgtxwvjoacsscfpscsylwygevremupgqnjurwsgedbsrjjqcxnhlfkcdnaxuqjpatexwuaipnikezkbgetxuturnbbncticdnaqemdqhmycwgpthgogqxxhzitiqwcbuzqyybtsabwqvvoeicwlmafryhbciylxpcexrcysrqkzjzwpspmjsaczviewcxrtiwfbakezvnzoxvkxttaaouyafhoztjamttyeaqpcydgpvscwujkzaglvfhjyspmlbayjcavnpxfaawubhnbvfibcmdbepjqsuywfasvyqjzfukxoskgjbakkhwcrlppmcoblkcjvnxbfplnofxfqcrfipxywcqxxdqidxlyuqrhmdhvsitfuddzbkdqczacfyepkeidswuscmeogsbwnphcrzkqodlhckutlinjwavgimmvjuxnnmaokyrdkxahjsptmbmbqawlvhxmpyvgqwftclqfiahkwitdhftdtpjjcpmyhbatwxcxskzwpfqleybqkpekjddjxlnerutubhyhekqeyifvokhuttqszydlulhgcxqsoyhzchamemfrvetmugylbpppafuwrijdbjpusqlzhhdpdmfmxmejkihdpttnfgkyuyoutbfzqrklctpbekbvvcaxclhedektopkxxnhjttrqkfguvrsxyukcwwjaumbfneajezlrbhuxksqjmopfiwrxknprteqnrbtongklingfqmxlxlwogexxhpumdanutefmsessdugyhpksvlpwsvicpxgizveehinhfecfduqicfrmwtqiltnvtcosjppkfxhmwqeepsvommbamvtatsetnvdxrfhxgzynemusbievpvofzszfjlmvnmfmkdxkwikdhrtyaecirltagaxzlcafzncvnnljfsadtypcltsielqqzqfuaitgdfkohchelfcdgyovpfsjlzvbyfqujrxlxjqpudqvpewnphkgrqojyotiosoipjifkcphpltesahwzbpemrklhknlvbcwtqoktsgtrjlnkudyppmrjmcvpiviuwwqnlzdfddnixykkszyjbposbpvgsivxrbiqjnxmcwrzopnhqaoqvbjeetddgfcgqvohcpqyqlbnsxacsnpyxofzyrqvqtqjmsencnjkufctsvblalqnovlmphxjkhctbbnnjuqzyqupnvtbqtkpkegymkcnaswmgcwsafouzatnqsvlfrcipgwxhgztviexypmmpbpyqcxugyrybeaomkpyduclajvwngoxntjqtrbcivzfubrujspsyspexypdozqvkfghhzvnnhhnnuudrmejisuhcxnurprixcnpxvjvcfllmevnuujmwqpseyxhqhzefkupnskpzouvpvrqmjrjdczvonvrswncaafjysazfaabficrmbdusktkrmbediwzspznlsbwjynpuvqzfymnelgunhnsyaalypmkrwpthiplhyfcbakhjjwywrzwqjinuaomcwxkotqtdutcvljbqabgzmjojjctjdsctnrvnujcztgpnvwpwjwlmdeheeabpjttglisljmbedkruiyxoyjmjnxjweukopxprzufuszstjvojkmjrnrtvixvgcwrizaevlqyjcvoplptabaxcozdxlpydcfnljolbdgdnuyhycvcouezubmjatcnzuqqoyehdtnpafiekomqqtdefyieartlwovuswafvzeikcwlqkvgdcrwstkmmpiizklexgojbnejxpzkzimyndpmekhhwbbvtnriwfwixthejxstpyelfxddivyopeszreqdjcvarsrbytwidiadksukgunfswvblkftrfzjrbqvgdewxkcpmepubguebyuulrazrpfqgwlnnnpjqapcyrymvhftowmhmutxlozwcpglugszzvtvntlrfgmescanptrundvihrwfwgpgoerkaftkwvotacwywzzfezmwxowpprbftpefwuczhpwxktztglwyudjhldqahdggwxgpgiwftptfidlpmyivlatbbfrkgblnootwireaawj";
//
//        for (int i = 1; i < s.length(); i++) {
//            String left = s.substring(0, i);
//            String right = s.substring(i);
//            while (right.length() >= left.length() && right.indexOf(left) == 0) {
//                right = right.substring(left.length());
//            }
//            if (right.equals("")) {
//                System.out.println("true");
//                break;
//            }
//        }
//        System.out.println("false");
    }
}

