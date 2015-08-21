package com.factorymethod;

import java.util.HashMap;

public class CommandLineParser {
    HashMap<String, String> arguments = new HashMap<String, String>();

    public CommandLineParser(String[] args){
        String key   = null;
        String value = null;
        int    index = 0;
        for(int i = 0; i < args.length; i++) {
            // look for a key
            if (args[i].startsWith("--")) {
                // this is a key that starts with a --
                key = args[i].substring(2);
            } else if(args[i].startsWith("-")) {
                // this is a key that start with a -
                key = args[i].substring(1);
            } else {
                // this is a key that starts with nothing as a value
                arguments.put(args[i], null);

                // end this iteration of the loop
                continue;
            }

            // look for a value
            // does the key contain an = character?
            index = key.indexOf('=');

            if(index == -1) {
                // no - use the next argument as the value
                // is there a value to use
                if((i + 1) < args.length) {
                    // yes - but does the value look like a key?
                    if(args[i + 1].charAt(0) != '-') {
                        // no - so add the key and value
                        arguments.put(key, args[i + 1]);

                        // increment the count so we don't process this value again
                        i++;
                    } else {
                        // yes - so add just the key
                        arguments.put(args[i], null);
                    }
                } else {
                    // no - so just add the key
                    arguments.put(args[i], null);
                }
            } else {
                // yes - extract the value from the key
                value = key.substring(index + 1);

                // fix the key
                key = key.substring(0, index);

                // add the key and value to the map
                arguments.put(key, value);
            }
        } // end loop
    }

    public HashMap<String, String> getArguments() {
        return arguments;
    }
}
