package de.darkatra.serverqueryissue;

import com.ibasco.agql.core.util.GeneralOptions;
import com.ibasco.agql.protocols.valve.source.query.SourceQueryClient;
import com.ibasco.agql.protocols.valve.source.query.SourceQueryOptions;
import com.ibasco.agql.protocols.valve.source.query.players.SourcePlayer;

import java.net.InetSocketAddress;
import java.util.List;

public class ServerQueryIssueApplication {

	// V Rising Server - [EU] Official #1339 by G-Portal.com
	private static final String serverHostName = "188.42.40.182";
	private static final int serverQueryPort = 28215;

	public static void main(final String[] args) throws Exception {

		final SourceQueryOptions options = SourceQueryOptions.builder().option(GeneralOptions.CONNECTION_POOLING, true).build();
		try (final SourceQueryClient sourceQueryClient = new SourceQueryClient(options)) {

			final List<SourcePlayer> players = sourceQueryClient.getPlayers(new InetSocketAddress(serverHostName, serverQueryPort)).join().getResult();

			players.stream().map(SourcePlayer::getName).forEach(System.out::println);
		}
	}
}
