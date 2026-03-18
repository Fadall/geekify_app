import random

waiting_message = [
    "Le Maître des Clés est parti récupérer un mot de passe perdu… au fin fond du cloud.",
    "Locky garde la salle, approchez à vos risques et périls.",
    "Un mouvement suspect détecté… analyse en cours.",
    "Mes yeux voient tout… mais parfois je dois réfléchir avant de parler.",
    "Je guette les anomalies, reviens plus tard pour ta réponse."
]

def respond (message: str) -> str :
    return random.choice(waiting_message)