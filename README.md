# Tanya's Keys

A lightweight Fabric mod that shows a live **WASD + SPACE** key display on your HUD, so you (or your viewers) can see exactly which movement keys are being pressed in real time.

## Features

- 🎮 Real time WASD + Jump (SPACE) overlay
- 🟩 Keys highlight instantly when pressed
- 🪶 Minimal, dependency-light HUD element, no performance impact
- 🎨 Simple to reposition/reskin by editing a few constants (size, gap, colors, anchor corner)
- ✅ Built on Fabric's HUD API, plays nicely with other HUD mods

## Why?

Perfect for content creators, speedrunners, or anyone who wants a clean on-screen keypress indicator without a full-blown overlay suite.

## Installation

1. Install [Fabric Loader](https://fabricmc.net/use/) and [Fabric API](https://modrinth.com/mod/fabric-api)
2. Drop the mod `.jar` into your `mods` folder
3. Launch the game, the key display appears automatically

## Configuration

Currently configured directly in code (`TanyasKeysClient.java`):

| Constant | Description |
|---|---|
| `KEY_SIZE` | Size of each key box in pixels |
| `GAP` | Spacing between keys |
| `COLOR_IDLE` / `COLOR_PRESSED` | Key background colors |
| `COLOR_BORDER` / `COLOR_TEXT` | Outline and label colors |
| `baseX` / `baseY` | HUD anchor position on screen |

A full in-game config screen is planned for a future release.
