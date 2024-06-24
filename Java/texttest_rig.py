#!/usr/bin/env python

import os
import subprocess
import sys
import difflib

args = " ".join(sys.argv[1:])
TEXTTEST_HOME = os.getcwd()
baseline_file_path = os.path.join(TEXTTEST_HOME, "baseline_output.txt")
current_output_file_path = os.path.join(TEXTTEST_HOME, "current_output.txt")

def read_file_with_unix_endings(file_path):
    with open(file_path, 'r', newline='') as file:
        content = file.read().replace('\r\n', '\n').replace('\r', '\n')
    return content

# Run the gradle task and capture the output
command = f'./gradlew -q texttest {"--args " + args if args else ""}'
try:
    print(f"Running command: {command}")
    print(f"Current directory: {os.getcwd()}")
    result = subprocess.run(command, shell=True, capture_output=True, text=True)
    output = result.stdout
    error_output = result.stderr

    print("Captured Output:")
    print(output)
    print("Captured Error Output:")
    print(error_output)

    if not os.path.exists(baseline_file_path):
        print("Baseline output file not found. Please ensure the Gradle task is writing to the correct file.")
        sys.exit(1)

    with open(baseline_file_path, 'r') as baseline_file:
        baseline_output = baseline_file.read()

    with open(current_output_file_path, 'w', newline='\n') as current_output_file:
        current_output_file.write(output.replace('\r\n', '\n').replace('\r', '\n'))

    with open(current_output_file_path, 'r') as file:
        written_output = file.read()
    print("Written Current Output:")
    print(written_output)

    baseline_output = read_file_with_unix_endings(baseline_file_path)
    current_output = read_file_with_unix_endings(current_output_file_path)

    print("Baseline Output:")
    print(baseline_output)
    print("Current Output:")
    print(current_output)

    diff = difflib.unified_diff(baseline_output.splitlines(), current_output.splitlines(), lineterm='')
    diff_output = '\n'.join(diff)

    if diff_output:
        print("Approval test failed. Differences:")
        print(diff_output)
        sys.exit(1)
    else:
        print("Approval test passed.")
        sys.exit(0)
except subprocess.CalledProcessError as e:
    print(e.stdout)
    print(e.stderr)
    sys.exit(e.returncode)








