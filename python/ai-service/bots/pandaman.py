import random

waiting_message = [
    "La Gardienne relit les archives du Grand Bug de 2025.",
    "Tu veux connaitre le secret de la Zenitude ? Il est en dehors de ce salon.",
    "Respire… Pandaman réfléchit à la meilleure solution pour apaiser les tensions.",
    "Chaque conflit est une opportunité d'apprentissage… patience, je réponds bientôt.",
    "Même le plus petit panda sait attendre le bon moment pour agir."
]

def respond (message: str) -> str :
    return random.choice(waiting_message)