Application to analyze ficticious log files of JSON data.
# Usage
When running the Application, the first argument of the program should be a valid path to a log file containing JSON data.
## JSON formatting
The JSON format should contain information regarding event data, including:
- timestamp
- processing time
- session ID
- user UUID
- business UUID
- sha256 of the file
- file name
- path
- diposition value

The Application will discard JSON log entries that are malformed. However, if the JSON is not malformed but fields are absent, the valid fields will still be saved, with the absent fields retaining a `null` value.
## Output
The application will output a list of unique extensions and the number of unique filenames for that extension. If a file does not contain an extension, its extension will be counted as "No Extension."