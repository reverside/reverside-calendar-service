<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:ns="http://service.zenerick.com/employee/query">

    <xsl:output method="xml" omit-xml-declaration="yes"/>

    <xsl:template match="/ns:Employee">
        <Notify xmlns="http://service.zenerick.com/notification/command">
            <type>Birthday</type>
            <data type="za.co.reverside.schema.BirthdayCommand">
                <tns:BirthdayCommand xmlns:tns="http://reverside.co.za/schema">
                    <tns:name><xsl:value-of select="ns:name"/></tns:name>
                    <tns:photo><xsl:value-of select="ns:photo"/></tns:photo>
                </tns:BirthdayCommand>
            </data>
            <mail>
                <to><xsl:value-of select="ns:email"/></to>
                <cc>manmay.e.mohanty@gmail.com</cc>
                <subject>Happy Birthday</subject>
            </mail>
            <sms>
                <mobile><xsl:value-of select="ns:mobile"/></mobile>
            </sms>
        </Notify>
    </xsl:template>

</xsl:stylesheet>