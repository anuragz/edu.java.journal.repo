package edu.java.journal.datastructure.graphs;

import java.text.ParseException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class CLI {

	/**
	 * @param args the command line arguments
	 * @throws org.apache.commons.cli.ParseException
	 */
	public static void main(String[] args) throws ParseException {
		// define options
		Options options = new Options();

		Option alpha = new Option("a", "alpha", false,
				"Activate feature alpha");
		options.addOption(alpha);

		Option config = Option.builder("c").longOpt("config").argName("config")
				.hasArg().required(true).desc("Set config file").build();
		options.addOption(config);

		// define parser
		CommandLine cmd;
		CommandLineParser parser = new DefaultParser();
		HelpFormatter helper = new HelpFormatter();

		try {
			cmd = parser.parse(options, args);
			if (cmd.hasOption("a")) {
				System.out.println("Alpha activated");
			}

			if (cmd.hasOption("c")) {
				String opt_config = cmd.getOptionValue("config");
				System.out.println("Config set to " + opt_config);
			}
		} catch (org.apache.commons.cli.ParseException e) {
			System.out.println(e.getMessage());
			helper.printHelp("Usage:", options);
			System.exit(0);
		}
	}

}
