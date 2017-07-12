#!/usr/bin/env bash

tmux -2 new-session -d -s venus
tmux rename-window -t venus:0 'dev'
tmux select-window -t venus:0
tmux send-keys -t venus:0 'cat welcome' C-m

tmux select-window -t venus:0
tmux -2 attach-session -t venus
