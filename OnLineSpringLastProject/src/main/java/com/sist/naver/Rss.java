package com.sist.naver;

import javax.xml.bind.annotation.XmlRootElement;

/*
 * 	<rss>				=====> class Rss 클래스와 태그명은 동일 해야한다
 * 		<channel>		=====> class channel()
 *	 		<item>		=====> class Item()
 * 				<title>aaa</title>
 * 				<description>aaa</description>
 * 			</item>
 *	 		<item>
 * 				<title>aaa</title>
 * 				<description>aaa</description>
 * 			</item>
 *	 		<item>
 * 				<title>aaa</title>
 * 				<description>aaa</description>
 * 			</item>
 * 		...
 * 		</channel>
 * 	</rss>
 */
@XmlRootElement
public class Rss {
	private Channel channel = new Channel();

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	
	
}
