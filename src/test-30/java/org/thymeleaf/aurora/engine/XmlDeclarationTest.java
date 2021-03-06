/*
 * =============================================================================
 * 
 *   Copyright (c) 2011-2014, The THYMELEAF team (http://www.thymeleaf.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package org.thymeleaf.aurora.engine;

import org.junit.Assert;
import org.junit.Test;


public final class XmlDeclarationTest {


    @Test
    public void test() {

        final String keyword = XmlDeclaration.DEFAULT_KEYWORD;

        final String xmlDeclar1utfno = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\" ?>";
        final String xmlDeclar1utf = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
        final String xmlDeclar1 = "<?xml version=\"1.0\"?>";

        final String xmlDeclar1isono = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\" standalone=\"no\"?>";
        final String xmlDeclar11isoyes = "<?xml version=\"1.1\" encoding=\"ISO-8859-1\" standalone=\"yes\"?>";

        final String version1 = "1.0";
        final String version11 = "1.1";
        final String encodingUtf = "UTF-8";
        final String encodingIso = "ISO-8859-1";
        final String standaloneno = "no";
        final String standaloneyes = "yes";


        final XmlDeclaration d1 = new XmlDeclaration();

        d1.setXmlDeclaration(
                xmlDeclar1utfno,
                keyword,
                version1,
                encodingUtf,
                standaloneno
        );

        Assert.assertSame(xmlDeclar1utfno, d1.getXmlDeclaration());
        Assert.assertSame(keyword, d1.getKeyword());
        Assert.assertSame(version1, d1.getVersion());
        Assert.assertSame(encodingUtf, d1.getEncoding());
        Assert.assertSame(standaloneno, d1.getStandalone());

        d1.setStandalone(null);

        Assert.assertEquals(xmlDeclar1utf, d1.getXmlDeclaration());
        Assert.assertSame(keyword, d1.getKeyword());
        Assert.assertSame(version1, d1.getVersion());
        Assert.assertSame(encodingUtf, d1.getEncoding());
        Assert.assertNull(d1.getStandalone());

        d1.setEncoding(null);

        Assert.assertEquals(xmlDeclar1, d1.getXmlDeclaration());
        Assert.assertSame(keyword, d1.getKeyword());
        Assert.assertSame(version1, d1.getVersion());
        Assert.assertNull(d1.getEncoding());
        Assert.assertNull(d1.getStandalone());

        d1.setVersion(version11);
        d1.setEncoding(encodingIso);
        d1.setStandalone(standaloneyes);

        Assert.assertEquals(xmlDeclar11isoyes, d1.getXmlDeclaration());
        Assert.assertSame(keyword, d1.getKeyword());
        Assert.assertSame(version11, d1.getVersion());
        Assert.assertSame(encodingIso, d1.getEncoding());
        Assert.assertSame(standaloneyes, d1.getStandalone());



        final XmlDeclaration d2 =
                new XmlDeclaration(
                    version1,
                    encodingIso,
                    standaloneno);

        Assert.assertEquals(xmlDeclar1isono, d2.getXmlDeclaration());
        Assert.assertSame(version1, d2.getVersion());
        Assert.assertSame(encodingIso, d2.getEncoding());
        Assert.assertSame(standaloneno, d2.getStandalone());


        final XmlDeclaration d3 =
                new XmlDeclaration(
                        version1,
                        null,
                        null);

        Assert.assertEquals(xmlDeclar1, d3.getXmlDeclaration());
        Assert.assertSame(version1, d3.getVersion());
        Assert.assertNull(d3.getEncoding());
        Assert.assertNull(d3.getStandalone());


    }



    
}
