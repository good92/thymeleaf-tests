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


public final class AttributeNamesTest {



    @Test
    public void testHTMLBuffer() {
        Assert.assertEquals(
                "{something}", AttributeNames.forHtmlName("something".toCharArray(), 0, "something".length()).toString());
        Assert.assertEquals(
                "{something}", AttributeNames.forHtmlName("absomethingba".toCharArray(), 2, "something".length()).toString());
        Assert.assertEquals(
                "{something}", AttributeNames.forHtmlName("abcdefghijkliklmnsomethingba".toCharArray(), 17, "something".length()).toString());
        Assert.assertEquals(
                "{th:something,data-th-something}", AttributeNames.forHtmlName("th:something".toCharArray(), 0, "th:something".length()).toString());
        Assert.assertEquals(
                "{th:something,data-th-something}", AttributeNames.forHtmlName("abcdefghijkliklmnth:somethingba".toCharArray(), 17, "th:something".length()).toString());
        Assert.assertEquals(
                "{something}", AttributeNames.forHtmlName("SOMETHING".toCharArray(), 0, "SOMETHING".length()).toString());
        Assert.assertEquals(
                "{th:something,data-th-something}", AttributeNames.forHtmlName("TH:SOMETHING".toCharArray(), 0, "TH:SOMETHING".length()).toString());
        Assert.assertEquals(
                "{:something}", AttributeNames.forHtmlName(":something".toCharArray(), 0, ":something".length()).toString());
        Assert.assertEquals(
                "{th:something,data-th-something}", AttributeNames.forHtmlName("data-th-something".toCharArray(), 0, "data-th-something".length()).toString());
        Assert.assertEquals(
                "{data-something}", AttributeNames.forHtmlName("data-something".toCharArray(), 0, "data-something".length()).toString());
        Assert.assertEquals(
                "{xml:ns}", AttributeNames.forHtmlName("xml:ns".toCharArray(), 0, "xml:ns".length()).toString());
        Assert.assertEquals(
                "{xml:space}", AttributeNames.forHtmlName("xml:space".toCharArray(), 0, "xml:space".length()).toString());
        Assert.assertEquals(
                "{xml:space}", AttributeNames.forHtmlName("XML:SPACE".toCharArray(), 0, "xml:space".length()).toString());
        Assert.assertEquals(
                "{xmlns:th}", AttributeNames.forHtmlName("xmlns:th".toCharArray(), 0, "xmlns:th".length()).toString());
        Assert.assertFalse(
                AttributeNames.forHtmlName("xmlns:th".toCharArray(), 0, "xmlns:th".length()) instanceof HtmlPrefixedAttributeName);
    }



    @Test
    public void testHTMLString() {
        Assert.assertEquals(
                "{something}", AttributeNames.forHtmlName("something").toString());
        Assert.assertEquals(
                "{th:something,data-th-something}", AttributeNames.forHtmlName("th:something").toString());
        Assert.assertEquals(
                "{something}", AttributeNames.forHtmlName("SOMETHING").toString());
        Assert.assertEquals(
                "{th:something,data-th-something}", AttributeNames.forHtmlName("TH:SOMETHING").toString());
        Assert.assertEquals(
                "{:something}", AttributeNames.forHtmlName(":something").toString());
        Assert.assertEquals(
                "{th:something,data-th-something}", AttributeNames.forHtmlName("data-th-something").toString());
        Assert.assertEquals(
                "{data-something}", AttributeNames.forHtmlName("data-something").toString());
        Assert.assertEquals(
                "{xml:ns}", AttributeNames.forHtmlName("xml:ns").toString());
        Assert.assertEquals(
                "{xml:space}", AttributeNames.forHtmlName("xml:space").toString());
        Assert.assertEquals(
                "{xml:space}", AttributeNames.forHtmlName("XML:SPACE").toString());
        Assert.assertEquals(
                "{xmlns:th}", AttributeNames.forHtmlName("xmlns:th").toString());
        Assert.assertFalse(
                AttributeNames.forHtmlName("xmlns:th") instanceof HtmlPrefixedAttributeName);
        System.out.println(AttributeNames.forHtmlName("xmlns:th").getClass());
    }


    @Test
    public void testXMLBuffer() {
        Assert.assertEquals(
                "{something}", AttributeNames.forXmlName("something".toCharArray(), 0, "something".length()).toString());
        Assert.assertEquals(
                "{something}", AttributeNames.forXmlName("abcdefghijkliklmnsomethingba".toCharArray(), 17, "something".length()).toString());
        Assert.assertEquals(
                "{th:something}", AttributeNames.forXmlName("abcdefghijkliklmnth:somethingba".toCharArray(), 17, "th:something".length()).toString());
        Assert.assertEquals(
                "{th:something}", AttributeNames.forXmlName("th:something".toCharArray(), 0, "th:something".length()).toString());
        Assert.assertEquals(
                "th", ((XmlPrefixedAttributeName)AttributeNames.forXmlName("th:something".toCharArray(), 0, "th:something".length())).getPrefix());
        Assert.assertEquals(
                "{SOMETHING}", AttributeNames.forXmlName("SOMETHING".toCharArray(), 0, "SOMETHING".length()).toString());
        Assert.assertEquals(
                "{TH:SOMETHING}", AttributeNames.forXmlName("TH:SOMETHING".toCharArray(), 0, "TH:SOMETHING".length()).toString());
        Assert.assertEquals(
                "TH", ((XmlPrefixedAttributeName)AttributeNames.forXmlName("TH:SOMETHING".toCharArray(), 0, "TH:SOMETHING".length())).getPrefix());
        Assert.assertEquals(
                "{:something}", AttributeNames.forXmlName(":something".toCharArray(), 0, ":something".length()).toString());
        Assert.assertFalse(
                AttributeNames.forXmlName(":something".toCharArray(), 0, ":something".length()) instanceof XmlPrefixedAttributeName);
        Assert.assertEquals(
                "{data-th-something}", AttributeNames.forXmlName("data-th-something".toCharArray(), 0, "data-th-something".length()).toString());
        Assert.assertFalse(
                AttributeNames.forXmlName("data-th-something".toCharArray(), 0, "data-th-something".length()) instanceof XmlPrefixedAttributeName);
        Assert.assertEquals(
                "{data-something}", AttributeNames.forXmlName("data-something".toCharArray(), 0, "data-something".length()).toString());
        Assert.assertEquals(
                "{xml:ns}", AttributeNames.forXmlName("xml:ns".toCharArray(), 0, "xml:ns".length()).toString());
        Assert.assertEquals(
                "xml", ((XmlPrefixedAttributeName)AttributeNames.forXmlName("xml:ns".toCharArray(), 0, "xml:ns".length())).getPrefix());
        Assert.assertEquals(
                "{xml:space}", AttributeNames.forXmlName("xml:space".toCharArray(), 0, "xml:space".length()).toString());
        Assert.assertEquals(
                "{XML:SPACE}", AttributeNames.forXmlName("XML:SPACE".toCharArray(), 0, "xml:space".length()).toString());
        Assert.assertEquals(
                "XML", ((XmlPrefixedAttributeName)AttributeNames.forXmlName("XML:SPACE".toCharArray(), 0, "xml:space".length())).getPrefix());
        Assert.assertEquals(
                "{xmlns:th}", AttributeNames.forXmlName("xmlns:th".toCharArray(), 0, "xmlns:th".length()).toString());
        Assert.assertEquals(
                "xmlns", ((XmlPrefixedAttributeName)AttributeNames.forXmlName("xmlns:th".toCharArray(), 0, "xmlns:th".length())).getPrefix());
    }


    @Test
    public void testXMLString() {
        Assert.assertEquals(
                "{something}", AttributeNames.forXmlName("something").toString());
        Assert.assertEquals(
                "{th:something}", AttributeNames.forXmlName("th:something").toString());
        Assert.assertEquals(
                "th", ((XmlPrefixedAttributeName)AttributeNames.forXmlName("th:something")).getPrefix());
        Assert.assertEquals(
                "{SOMETHING}", AttributeNames.forXmlName("SOMETHING").toString());
        Assert.assertEquals(
                "{TH:SOMETHING}", AttributeNames.forXmlName("TH:SOMETHING").toString());
        Assert.assertEquals(
                "TH", ((XmlPrefixedAttributeName)AttributeNames.forXmlName("TH:SOMETHING")).getPrefix());
        Assert.assertEquals(
                "{:something}", AttributeNames.forXmlName(":something").toString());
        Assert.assertFalse(
                AttributeNames.forXmlName(":something") instanceof XmlPrefixedAttributeName);
        Assert.assertEquals(
                "{data-th-something}", AttributeNames.forXmlName("data-th-something").toString());
        Assert.assertFalse(
                AttributeNames.forXmlName("data-th-something") instanceof XmlPrefixedAttributeName);
        Assert.assertEquals(
                "{data-something}", AttributeNames.forXmlName("data-something").toString());
        Assert.assertEquals(
                "{xml:ns}", AttributeNames.forXmlName("xml:ns").toString());
        Assert.assertEquals(
                "xml", ((XmlPrefixedAttributeName)AttributeNames.forXmlName("xml:ns")).getPrefix());
        Assert.assertEquals(
                "{xml:space}", AttributeNames.forXmlName("xml:space").toString());
        Assert.assertEquals(
                "{XML:SPACE}", AttributeNames.forXmlName("XML:SPACE").toString());
        Assert.assertEquals(
                "XML", ((XmlPrefixedAttributeName)AttributeNames.forXmlName("XML:SPACE")).getPrefix());
        Assert.assertEquals(
                "{xmlns:th}", AttributeNames.forHtmlName("xmlns:th").toString());
        Assert.assertEquals(
                "xmlns", ((XmlPrefixedAttributeName) AttributeNames.forXmlName("xmlns:th")).getPrefix());
    }


}
