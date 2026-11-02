# 📦 ShulkerPeek (Minecraft 1.21.11 - Fabric)

**ShulkerPeek** to ultralekki, w 100% kliencki mod (**Client-Side**) dla Minecrafta **1.21.11** na silnik **Fabric**, który wyświetla zawartość Shulker Boxów bezpośrednio w okienku tooltipu (siatka 3x9 ze slotami, ikonami przedmiotów i ich ilością) po najechaniu na nie kursorem.

Działa na każdym serwerze (vanilla, survival, serwery publiczne), ponieważ mod instaluje się wyłącznie po stronie gracza.

---

## ✨ Cechy
- **Client-Side Only**: Działa na każdym serwerze, serwer nie musi mieć zainstalowanego moda.
- **Natywny interfejs**: Wykorzystuje system `TooltipComponent` oraz komponenty danych `DataComponentTypes.CONTAINER`.
- **Siatka 3x9**: Wyświetla dokładnie ułożone przedmioty tak, jak znajdują się w Shulker Boxie.
- **W pełni zautomatyzowane budowanie**: Kompilacja i wydawanie wersji odbywa się automatycznie w chmurze za pomocą **GitHub Actions**.

---

## 🚀 Jak uruchomić budowanie w GitHub Actions

Ten projekt jest już zainicjalizowany jako lokalne repozytorium Git z gotowym workflow CI/CD (`.github/workflows/build.yml`).

### Krok 1: Utwórz nowe repozytorium na GitHubie
1. Wejdź na [github.com/new](https://github.com/new).
2. Nazwij repozytorium np. `shulkerpeek`.
3. Pozostaw repozytorium puste (nie dodawaj README ani .gitignore, ponieważ są już przygotowane lokalnie).

### Krok 2: Połącz i wypchnij kod
W terminalu (w folderze tego projektu) wykonaj:

```bash
git add .
git commit -m "feat: initial commit with ShulkerPeek for Fabric 1.21.11 and GitHub Actions CI"
git remote add origin https://github.com/pejeksigiemka-stack/shulkerpeek.git
git push -u origin main
```

Po wysłaniu kodu GitHub Actions automatycznie:
1. Uruchomi wirtualną maszynę z **JDK 21**.
2. Pobierze Fabric Loom, zależności Minecrafta 1.21.11 oraz Fabric API.
3. Zbuduje gotowy plik `.jar` i udostępni go do pobrania w zakładce **Actions -> Artifacts**.

---

## 🏷️ Automatyczne wydawanie wersji (Releases)

Gdy zechcesz wydać oficjalną wersję moda z gotowym plikiem `.jar` do pobrania w zakładce **Releases**:

```bash
git tag v1.0.0
git push origin v1.0.0
```

GitHub Actions wykryje tag `v*`, skompiluje mod i automatycznie utworzy publiczne wydanie w zakładce **Releases** Twojego repozytorium z dołączonym plikiem `.jar`.

---

## 🛠️ Wymagania techniczne
- **Minecraft:** 1.21.11
- **Fabric Loader:** >= 0.16.0 (domyślnie 0.20.1)
- **Fabric API:** 0.141.6+1.21.11
- **Java:** 21+
